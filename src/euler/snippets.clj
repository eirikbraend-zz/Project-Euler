(ns euler.snippets)

(defn factors [n]
  (loop [prim (primes n) res [] foo n]
    (if (nil? (first prim))
      res
      (do
        (if (= 0 (mod foo (first prim)))
          (recur prim (conj res (first prim)) (/ foo (first prim)))
          (recur (rest prim) res foo))))))

(defn factors [n] 
  (loop [c 2
         m n
         res []]
    (if (> c m)
      res
      (if (= 0 (mod m c))
        (recur c (/ m c) (conj res c))
        (recur (inc c) m res)))))