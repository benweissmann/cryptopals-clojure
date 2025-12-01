(ns cryptopals-clojure.p4
  (:require [cryptopals-clojure.common.encoding :as encoding]
            [cryptopals-clojure.common.text-score :as text-score]
            [cryptopals-clojure.common.xor :as xor]
            [clojure.java.io :as io]))



(defrecord Ciphertext [ciphertext best-key plaintext])

(defn load-record [ciphertext]
  (let [cryptkey (apply max-key
                        (fn [chr]
                          (-> ciphertext
                              (xor/single-char-xor chr)
                              encoding/bytes2str
                              text-score/score-text))
                        (map char (range 0 128)))]

    (Ciphertext.
     ciphertext
     cryptkey
     (-> ciphertext (xor/single-char-xor cryptkey) encoding/bytes2str))))

(defn find-single-char-xor [lines]
  (apply max-key
         (fn [line] (text-score/score-text (.plaintext line)))
         (map load-record lines)))


(let [s (io/resource "p4input.txt")]
  (with-open [r (io/reader s)]
    (find-single-char-xor (map encoding/hex2bytes (line-seq r)))))
