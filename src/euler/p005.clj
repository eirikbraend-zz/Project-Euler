(ns euler.p005)

;; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

(defn primes [n] 
  (loop [m 2 res []]
    (if (= m n)
      res
      (recur (inc m) (if (not-any? #(= 0 (mod m %1)) res) (conj res m) res)))))

(defn antall [x n]
  (loop [tell 0]
    (if (> (apply * (repeat tell x)) n)
      (apply * (repeat (dec tell) x))
      (recur (inc tell)))))

(reduce * (map #(antall % 20) (primes 20)))
