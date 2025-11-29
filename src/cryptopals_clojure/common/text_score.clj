(ns cryptopals-clojure.common.text-score)

(def char-freqs {\A 0.084966
                 \B 0.020720
                 \C 0.045388
                 \D 0.033844
                 \E 0.1011607
                 \F 0.018121
                 \G 0.024705
                 \H 0.030034
                 \I 0.075448
                 \J 0.001965
                 \K 0.011016
                 \L 0.054893
                 \M 0.030129
                 \N 0.066544
                 \O 0.071635
                 \P 0.031671
                 \Q 0.001962
                 \R 0.075809
                 \S 0.057351
                 \T 0.069509
                 \U 0.036308
                 \V 0.010074
                 \W 0.012899
                 \X 0.002902
                 \Y 0.017779
                 \Z 0.002722
                 \  0.025
                 \_ 0})

(def max-char-freq
  (apply max (vals char-freqs)))


(defn score-text [str]
  (/
   (apply + (map
             (fn [c]
               (or (get char-freqs c) (- 0 max-char-freq)))
             (clojure.string/upper-case str)))
   (* (count str) max-char-freq)))

(comment
  (score-text "!!!!")

  :rcf)
