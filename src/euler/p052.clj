(ns p052)

;It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, 
;but in a different order.

;Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.

(defn same-digits [x1 x2]
  (let [prep (fn [x] (sort (seq (str x))))]
    (= (prep x1) (prep x2))))

(defn make-multiply-functions [nums]
  (map #(fn [x] (same-digits (* % x) x)) nums))

(def match (apply juxt (make-multiply-functions (range 2 7))))

(defn find-int []
  (loop [n 1]
    (if (every? true? (match n))
      n
      (recur (inc n)))))

;(find-int)

; 142857