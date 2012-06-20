(ns euler.p010
  (:import [java.lang Math]))

; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
; Find the sum of all the primes below two million.

(defn primes [n] 
  (loop [m 3 res []]
    (let [root (-> (Math/sqrt m) int inc)]
      (if (> m n)
        (cons 2 res)
        (recur (inc (inc m)) (if (not-any? #(= 0 (mod m %1)) (take-while #(< % root) res)) (conj res m) res))))))

(reduce + (primes 2000000))