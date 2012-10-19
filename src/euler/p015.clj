(ns euler.p015
  (:require [euler.utils :as util]))

;Starting in the top left corner of a 2 x 2 grid, there are 6 routes (without backtracking) 
;to the bottom right corner.
;
;How many routes are there through a 20 x 20 grid?

; ------------

; select k from n:
; n! / k! (n - k)!

;; multiplicative formula:
(defn binomial [n k]
  (let [func (fn [x] (/ (- n (- k x)) x))]
   (reduce * (map func (range 1 (inc k))))))

;; 137846528820
