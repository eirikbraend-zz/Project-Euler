(ns euler.p013)

;Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.

(def input (clojure.string/split-lines (slurp "resources/p013-input.txt")))

(subs (str (reduce + (map bigint input))) 0 10)

;; 5537376230