(require 'cryptopals-clojure.common.encoding)
(refer 'cryptopals-clojure.common.encoding)


(require 'cryptopals-clojure.common.xor)
(refer 'cryptopals-clojure.common.xor)

(require 'cryptopals-clojure.common.text-score)
(refer 'cryptopals-clojure.common.text-score)


(def ciphertext
  (hex2bytes "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"))

(def cryptkey
  (apply max-key
         (fn [chr]
           (score-text
            (bytes2str
             (single-char-xor
              ciphertext
              chr))))
         (map char (range 0 128))
         ))

(bytes2str
 (single-char-xor
  ciphertext
  cryptkey))


