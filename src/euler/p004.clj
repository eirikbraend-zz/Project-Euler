(ns euler.p004)

;; A palindromic number reads the same both ways.
;; The largest palindrome made from the product of two 2-digit numbers is 9009 = 91  99.
;; Find the largest palindrome made from the product of two 3-digit numbers.

(defn palindrome? [n]
  (let [s (str n)]
    (= (apply str (reverse s)) s)))

(apply max (for [x (range 1000 0 -1)
                 y (range 1000 0 -1)
                 :let [prod (* x y)]
                 :when (palindrome? prod)]
             prod))

