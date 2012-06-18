(ns euler.p008)

(def input (partition 5 1 (slurp "resources/p008-input.txt")))

(defn multiply [x]
  (apply * (map #(- (int %) 48) x)))

(apply max (map multiply input))
