(ns euler.p092)

;A number chain is created by continuously adding the square of the digits in
;a number to form a new number until it has been seen before.
;For example,
;
;44  32  13  10  1  1
;85  89  145  42  20  4  16  37  58  89
;
;Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop.
;What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.
;How many starting numbers below ten million will arrive at 89?

(defn square [x] (* x x))
  
(defn to-int [n] (- (int n) 48))

(defn to-int-seq [n] (map to-int (seq (str n))))

(defn square-and-add [x] 
  (reduce + (map square (to-int-seq x))))

(defn done? [n] (or (= n 1) (= n 89)))

(defn chain-number [n]
  (loop [n n]
    (if (done? n) 
      n
      (recur (square-and-add n)))))

(def input (range 1 1000000))

(defn total-count [n]
  (count (filter #(= % 89) (map chain-number n))))

; (total-count input)
; 8581146