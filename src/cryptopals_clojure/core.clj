


(ns cryptopals-clojure.core
  (:gen-class))




(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(comment
  (require 'cryptopals-clojure.common.encoding)
  (refer 'cryptopals-clojure.common.encoding)

  ;; (require 'cryptopals-clojure.common.encoding)
  ;; (alias 'encoding 'cryptopals-clojure.common.encoding)

  (bytes2str (hex2bytes "48656c6c6f2c20576f726c6421"))
  (bytes2hex (str2bytes "Hello, World!"))

  (bytes2b64 (hex2bytes "48656c6c6f2c20576f726c6421"))
  (bytes2str (b642bytes "SGVsbG8sIFdvcmxkIQ=="))

  :rcf)






