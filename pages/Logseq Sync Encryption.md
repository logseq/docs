type:: #Feature

- > This doc describes the #[[Logseq Sync]] encryption scheme.
- ## Client-side Encryption in Logseq File Sync
	- Basic algorithm: [Age Encryption](https://github.com/FiloSottile/age) and [ChaCha20-Poly1305](https://en.wikipedia.org/wiki/ChaCha20-Poly1305)
	- Implementation: <https://github.com/logseq/rsapi/tree/master/lsq-encryption>
- ### File Encryption
	- Use standard Age Encryption.
	- File content is encrypted and decrypted with a pair of age encryption keys
	- The Age encryption key is encrypted with user's passphrase. This is where the "Graph unlocking" comes from.
	- ```
	  ("AGE-SECRET-KEY-1YR7DJEF0LYKW8Z5MCW3.......TMWF0ZY7P2QGU4UY9", 
	   "age1m74wwsxtj.......w4drsvsyrjvuqlpga92")
	  ```
- ### Filename Encryption
	- A modified version of ChaCha20-Poly1305. Weaker, bug good enough for filenames.
	- In short
		- Use the raw x25519 key from above Age encryption. It's a 256-bit key.
		- The `nonce` in `ChaCha20-Poly1305` is filled with zero bytes, for non-random result
		- Join `e.` prefix and hex-encoded ciphertext
	- Demo:
		- ```
		  We start from an age encryption private key:
		  
		  "AGE-SECRET-KEY-1KZEJZYUPL49REUU985P.......RRQX9MJF8DXQRRA7J0"
		  
		  Convert it to Raw x25519 Key:
		  
		  "...(some 32 bytes binary)...."
		  
		  To encrypt "pages/contents.md"(nonce = 96bits, all zeros):
		  
		  Got a ciphertext binary: "6dd3a5340dd904be0e509ff824c32cdc1db108166bf58a4a8f3f5299651282ffca"
		  
		  Prefix it with "e."
		  
		  "e.6dd3a5340dd904be0e509ff824c32cdc1db108166bf58a4a8f3f5299651282ffca"
		  ```