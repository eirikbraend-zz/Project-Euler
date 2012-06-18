(ns euler.p003)

;;The prime factors of 13195 are 5, 7, 13 and 29.
;;What is the largest prime factor of the number 600851475143 ?

(defn factors [n] 
  (loop [c 2
         m n
         res []]
    (if (> c m)
      res
      (if (= 0 (mod m c))
        (recur c (/ m c) (conj res c))
        (recur (inc c) m res)))))

(apply max (factors 600851475143))

