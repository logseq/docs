- You can set your preferred daily journal date format via `Settings` page
- Alternatively, you can add it in [[config.edn]]
	- {{embed ((60acdeb9-aa65-492b-8398-d4d65c1631c1))}}
	- Add your favorite date-formatter to [[config.edn]]:
	  #+BEGIN_SRC clojure
	  :date-formatter "yyyy-MM-dd"
	  #+END_SRC
	  Currently, logseq support:
	  #+BEGIN_SRC clojure
	       "MMM do, yyyy"
	       "E, MM/dd/yyyy"
	       "E, yyyy/MM/dd"
	       "EEE, MM/dd/yyyy"
	       "EEE, yyyy/MM/dd"
	       "EEEE, MM/dd/yyyy"
	       "EEEE, yyyy/MM/dd"
	       "MM/dd/yyyy"
	       "MM-dd-yyyy"
	       "MM_dd_yyyy"
	       "yyyy/MM/dd"
	       "yyyy-MM-dd"
	       "yyyy_MM_dd"
	       "yyyy年MM月dd日"
	  #+END_SRC