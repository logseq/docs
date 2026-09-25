// Post-build fixes for static hosts (e.g. devinapps) that serve the root
// index.html for ANY extensionless path instead of resolving directory
// indexes:
//
// 1. Rewrite every internal extensionless link href="/foo/" (or "/foo")
//    to href="/foo/index.html" in every emitted HTML file. This matters
//    for Astro's ClientRouter: it fetches the href on navigation, and a
//    fetch for "/foo/" returns the root document — the URL changes but
//    the page never does.
// 2. Keep a redirect shim in dist/index.html so external/bookmarked
//    extensionless URLs still land on the right page.
import { readFileSync, writeFileSync, readdirSync, statSync } from "node:fs";
import { join } from "node:path";

const dist = new URL("../dist", import.meta.url).pathname;

const FILE_EXT = /\.[a-z0-9]{1,10}$/i;

function htmlFiles(dir) {
  const out = [];
  for (const name of readdirSync(dir)) {
    const p = join(dir, name);
    if (statSync(p).isDirectory()) out.push(...htmlFiles(p));
    else if (name.endsWith(".html")) out.push(p);
  }
  return out;
}

let rewritten = 0;
const HREF = /href="(\/[^"#?]*?)"/g;
for (const file of htmlFiles(dist)) {
  const html = readFileSync(file, "utf8");
  const next = html.replace(HREF, (m, path) => {
    const clean = path.replace(/\/+$/, "");
    if (clean === "" || FILE_EXT.test(clean)) return m;
    return `href="${clean}/index.html"`;
  });
  if (next !== html) {
    writeFileSync(file, next);
    rewritten++;
  }
}
console.log(`rewrote extensionless hrefs in ${rewritten} files`);

const file = join(dist, "index.html");
const html = readFileSync(file, "utf8");

const shim = `<script>
  (() => {
    const p = location.pathname;
    const isFile = /\\.[a-z0-9]{1,10}$/i.test(p);
    if (p !== "/" && !isFile) {
      location.replace(p.replace(/\\/$/, "") + "/index.html" + location.search + location.hash);
    }
  })();
</script>`;

if (html.includes("location.replace(p.replace")) {
  console.log("shim already present");
} else {
  writeFileSync(file, html.replace("<head>", "<head>" + shim));
  console.log("injected fallback shim into dist/index.html");
}
