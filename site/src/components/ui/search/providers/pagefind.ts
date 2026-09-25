import type { SearchProvider, SearchResult } from "@cloudflare/nimbus-docs/types";
import { config } from "virtual:nimbus/config";

interface PagefindSubResult {
  title?: string;
  url?: string;
}

interface PagefindResultData {
  url: string;
  excerpt?: string;
  meta?: { title?: string };
  sub_results?: PagefindSubResult[];
}

interface PagefindSearchResponse {
  results: Array<{ data(): Promise<PagefindResultData> }>;
}

interface PagefindFilters {
  [key: string]: string | string[] | { none?: string | string[]; any?: string | string[] };
}

interface PagefindApi {
  init(): Promise<void>;
  search(query: string, options?: { filters?: PagefindFilters }): Promise<PagefindSearchResponse>;
}

let pagefind: PagefindApi | undefined;

function withBase(url: string): string {
  if (!url.startsWith("/")) return url;
  const base = `/${(import.meta.env.BASE_URL ?? "/").replace(/^\/+|\/+$/g, "")}`;
  if (base === "/" || url === base || url.startsWith(`${base}/`)) return url;
  return `${base}${url}`;
}

/**
 * Point result links at the real emitted file (`<path>/index.html`).
 * Hosts that return the root document for extensionless paths would
 * otherwise feed ClientRouter the homepage for every result.
 */
function pageUrl(url: string): string {
  const u = withBase(url);
  const clean = u.replace(/\/+$/, "");
  if (clean === "" || /\.[a-z0-9]{1,10}$/i.test(clean)) return u;
  return `${clean}/index.html`;
}

/**
 * Default Pagefind filters applied to every search.
 *
 * Versioning: when the site has a `versions.deprecated` list, the
 * layout emits `data-pagefind-filter="status:deprecated"` on every
 * deprecated-version page. Search defaults to current and non-deprecated
 * results.
 */
/**
 * Scope searches to the version the reader is currently browsing:
 * on a `/zh/...` page only zh results come back, on any other page only
 * the current-version (en) results. Also keeps the default deprecated
 * exclusion described above.
 */
function currentFilters(): PagefindFilters | undefined {
  const filters: PagefindFilters = {};
  const others = config.versions?.others ?? [];
  const current = config.versions?.current ?? "en";
  const path = window.location.pathname;
  const matched = others.find(
    (v) => path === `/${v}` || path.startsWith(`/${v}/`) || path === `/${v}/index.html` || path.startsWith(`/${v}/index.html`),
  );
  filters.version = matched ?? current;
  if (config.versions?.deprecated && config.versions.deprecated.length > 0) {
    filters.status = { none: "deprecated" };
  }
  return filters;
}

export const provider: SearchProvider = {
  async init() {
    if (pagefind) return;
    const baseUrl = new URL(import.meta.env.BASE_URL ?? "/", window.location.origin);
    const pagefindUrl = new URL("pagefind/pagefind.js", baseUrl);
    pagefind = (await import(/* @vite-ignore */ pagefindUrl.href)) as PagefindApi;
    await pagefind.init();
  },

  async search(query) {
    if (!pagefind) await this.init?.();
    if (!pagefind) return [];

    const search = await pagefind.search(query, { filters: currentFilters() });
    const results = await Promise.all(search.results.slice(0, 10).map((result) => result.data()));
    return results.map((result): SearchResult => ({
      title: result.meta?.title ?? "Untitled",
      url: pageUrl(result.url),
      snippet: result.excerpt,
      subResults: result.sub_results
        ?.filter((sub): sub is Required<PagefindSubResult> => Boolean(sub.title && sub.url))
        .map((sub) => ({ title: sub.title, url: pageUrl(sub.url) })),
    }));
  },
};
