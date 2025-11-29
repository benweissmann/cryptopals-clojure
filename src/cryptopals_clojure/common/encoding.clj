(ns cryptopals-clojure.common.encoding)

(import java.util.Base64)
(import java.math.BigInteger)

(defn str2bytes [s] (.getBytes s))

(defn bytes2str [b] (apply str (map char b)))

(defn hex2bytes [hex]
  (byte-array
   (map
    (fn [[x y]] (byte (Integer/parseInt (str x y) 16)))
    (partition 2 hex))))


(defn bytes2hex [b]
  (format "%x" (new java.math.BigInteger b)))

(defn bytes2b64 [to-encode]
  (.encodeToString (Base64/getEncoder)  to-encode))

(defn b642bytes [to-decode]
  (.decode (Base64/getDecoder) to-decode))
