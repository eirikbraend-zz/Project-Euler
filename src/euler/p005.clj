(ns euler.p005)

;; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

(defn factors [n] 
  (loop [c 2
         m n
         res []]
    (if (> c m)
      res
      (if (= 0 (mod m c))
        (recur c (/ m c) (conj res c))
        (recur (inc c) m res)))))

(map factors (range 2 21))
