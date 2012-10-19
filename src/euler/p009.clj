(ns euler.p009)

; http://projecteuler.net/problem=9

;; (for [a (range 1 100) b (range 1 100) c (range 1 100) :when (and (= (+ a b c ) 1000) (< a b) (< b c)) ] [a b c]) 


(defn tall [n]
  (for [a (range 1 n) b (range 1 n) c (range 1 n) 
        :when (and 
                (= (+ a b c) n)
                (< a b)
                (< b c)
                (= (+ (* a a) (* b b)) (* c c)))
        ] [a b c]))

(defn pytho? [[a b c]]
  (= (+ (* a a) (* b b)) (* c c)))

;;(reduce * [200 375 425])

;;31875000