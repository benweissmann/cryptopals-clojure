(require 'cryptopals-clojure.common.encoding)
(refer 'cryptopals-clojure.common.encoding)


(require 'cryptopals-clojure.common.xor)
(refer 'cryptopals-clojure.common.xor)

(bytes2hex
 (xor
  (hex2bytes "1c0111001f010100061a024b53535009181c")
  (hex2bytes "686974207468652062756c6c277320657965")))


