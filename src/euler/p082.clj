(ns euler.p082
  (:require [clojure.string :as str]
            [clojure.math.numeric-tower :as math]))


(def small [131 673 234 103 18, 201 96 342 965 150, 630 803 746 422 111, 537 699 497 121 956, 805 732 524  37 331])
(def big (vec (map read-string (str/split (slurp "resources/p081-input.txt") #",|\n"))))
(def input big)

(def n (count input))
(def s (math/sqrt n))

(def seed-corner (vec (cons (first input) (repeat (dec n) nil))))

(def two-ways   [:right :down])
(def three-ways [:right :down :up])
(def four-ways  [:right :down :up :left])

(defn all-n [n]
  (for [x (range n) :let [left (dec x)
                          right (inc x)
                          down (+ x s)
                          up    (- x s)]]
    {:left left :right right :down down :up up } ))

(defn moding [func limit]
  (fn [x] (not (zero? (mod (func x) limit)))))

(defn filter-ways [ways coll]
  (map #(select-keys % ways) coll))

(def legal
  {:left  (moding inc s)
   :right (moding identity s)
   :up    (comp not neg?)
   :down  (partial > n) })

(defn baz [[nokkel verdi]]
  ((nokkel legal) verdi))

(defn bar [move]
  (filter baz move))

(defn filter-legal [foo coll]
  (map foo coll))

(def wtf (->> n
              all-n 
              (filter-ways four-ways)
              (filter-legal bar)))

(def mv (map #(map second %) wtf))
;;;;;;;;;;;;;;;;;;;;;;;;


(defn single-move [curr move]
  (let [tmp (keep identity (map curr move))]
    (when (seq tmp)
      (apply min tmp))))

(defn min-path [moves curr]
  (map (partial single-move curr) moves))

(defn best [org min-nabo current]
  (if (not (nil? min-nabo))
    (if (nil? current)
      (+ org min-nabo)
      (min (+ org min-nabo) current))
    current))

(defn neste [original moves current]
  (let [min-naboer (min-path moves current)]
    (map best original min-naboer current)))

(defn minimal-path [moves original seed]
  (loop [current seed, counter n]
    (if (zero? counter)
      current
      (recur (neste original moves (vec current)) (dec counter)))) )

;(last (minimal-path mv input seed-corner))