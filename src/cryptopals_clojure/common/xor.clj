(ns cryptopals-clojure.common.xor)

 (defn xor [bytes1 bytes2]
   (byte-array (map
    (fn [x, y] (bit-xor x y))
    bytes1
    bytes2)))

 (defn single-char-xor [bytes chr]
   (xor bytes (repeat (byte chr))))

(comment
  (xor (byte-array [(byte 2r1010)]) (byte-array [(byte 2r1100)]))

  (single-char-xor
   (byte-array [(byte 1) (byte 2)])
   \X)

  :rcf)
