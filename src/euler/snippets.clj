(ns euler.snippets)

(defn prime [n]
  (let [sq (Math/sqrt n)]
  (loop [m 1 max 0]
    (if (= m n)
      max
      (recur (inc m) (if (= 0 (mod n m)) m max))))
  ))

(Math/sqrt 16)

;; prob 5
;; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

(defn primes [n] 
  (loop [m 2 res []]
    (if (= m (inc n))
      res
      (recur (inc m) (if (not-any? #(= 0 (mod m %1)) res) (conj res m) res)))))

(reduce * (flatten (distinct (map primes (range 3 10)))))

(defn factors [n]
  (loop [prim (primes n) res [] foo n]
    (if (nil? (first prim))
      res
      (do
        (if (= 0 (mod foo (first prim)))
          (recur prim (conj res (first prim)) (/ foo (first prim)))
          (recur (rest prim) res foo))))))

