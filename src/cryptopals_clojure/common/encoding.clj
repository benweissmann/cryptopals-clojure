(ns cryptopals-clojure.common.encoding
    (:import (org.apache.commons.codec.binary Hex)))

(import java.util.Base64)

(defn str2bytes [s] (.getBytes s))

(defn bytes2str [b] (apply str (map unchecked-char b)))

(defn hex2bytes [hex]
  (Hex/decodeHex (.toCharArray hex)))

(defn bytes2hex [b]
  (Hex/encodeHexString b))

(defn bytes2b64 [to-encode]
  (.encodeToString (Base64/getEncoder)  to-encode))

(defn b642bytes [to-decode]
  (.decode (Base64/getDecoder) to-decode))

(comment
  (bytes2hex (hex2bytes "4f"))
  (bytes2str (str2bytes "foo"))
  (bytes2b64 (b642bytes "foo="))

  :rcf)
