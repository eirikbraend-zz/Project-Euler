(ns euler.p083
  (:require [clojure.string :as str]
            [clojure.math.numeric-tower :as math]))


(def small [131 673 234 103 18, 201 96 342 965 150, 630 803 746 422 111, 537 699 497 121 956, 805 732 524  37 331])

;; static
;; Needs size and offset!!
;; all in one func and use maps??
;; then filter map 
(defn left [x]
  (if (zero? (rem x offset)) nil (dec x)))

(defn right [x]
  (if (zero? (rem (inc x) offset)) nil (inc x)))

(defn up [x]
  (if (< x offset) nil (- x offset)))

(defn down [x]
  (if (> x (- size (inc offset))) nil (+ x offset)))

(def two-ways   [left, up])
(def three-ways [left, up, down])
(def four-ways  [left, up, down, right])

;; dynamic 
(defn nei-cords [movement, size]
  (let [tmp (apply juxt movement)] 
    (map #(tmp  %) (range size))))


(def nei-fil (map #(keep identity %) nei))

(defn min-neig [curr neigh-coords]
  (apply min (map #(curr %) neigh-coords)))

;; single values, except neighbours
;; calculate the smallest value of smallest neighbour pluss original value and smallest value so far.
(defn new-min [org curr neigh]
  (let [minn (min-neig curr neigh)]
    (min (+ org minn) curr)))

(defn ny-liste [] 
  (map #(list %1 %2 %3) small (repeat size 99999) nei-fil))

;; input: liste med tall
;; moves: funksjon som anvendt paa input stoerrelse gir naboer til coordinater
;; seed: funsjon? gir start liste?? koordinater til startliste?
(defn minimal-path [input moves seed]
  (let [size (count input)
        ]
    (loop [current input, counter size]
      (if (zero? counter) 
        current
        (recur current (dec counter)))) ))

(minimal-path small 1 3)

(defn magi [f]
  (keep identity f))

(for [x (range 9) :let [left (dec x)
                        right (inc x)
                        up (- x 3)
                        down (+ x 3)]
      ] (magi [left right up down]))

(for [x (range 3)
      :let [left (dec x)
            right (inc x)
            up (dec x)
            down (inc x)]
      ]
  [[left x] [right x] [x down] [x up]])

