(ns euler.p008)

; Find the greatest product of five consecutive digits in the 1000-digit number.

(def input (partition 5 1 (slurp "resources/p008-input.txt")))

(defn multiply [x]
  (apply * (map #(- (int %) 48) x)))

(apply max (map multiply input))
