(ns euler.p007)

;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
;; What is the 10 001st prime number?

(defn primes [n] 
  (loop [m 2 res []]
    (if (= (count res) n)
      res
      (recur (inc m) (if (not-any? #(= 0 (mod m %1)) res) (conj res m) res)))))

(last (primes 10001))