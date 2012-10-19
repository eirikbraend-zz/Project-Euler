(ns euler.utils
  (:import [java.lang Math Integer]))


;(Math/sqrt m)

(defn parse-int [n]
  (. Integer parseInt n))

(defn divisible? [dividend divisor]
  (zero? (mod dividend divisor)))

(defn factorial [n]
  (reduce #(* %1 (bigint %2)) (bigint 1) (range 1 (inc n))))