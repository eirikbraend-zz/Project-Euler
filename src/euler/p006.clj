(ns euler.p006)

;; http://projecteuler.net/problem=6

(def rekke (range 1 101 1))

(def square-sum (reduce + (map #(* % %) rekke)))
(def sum-square (let [sum (reduce + rekke)] (* sum sum)))
(- sum-square square-sum)