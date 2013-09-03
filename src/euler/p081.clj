(ns euler.p081
  (:require [clojure.string :as str]))

(def input (slurp "resources/p081-input.txt"))

(def tall (map read-string (str/split input #",")))

(def small [
[131    673	234	103	18]
[201	96	342	965	150]
[630	803	746	422	111]
[537	699	497	121	956]
[805	732	524	37	331]
])


;; flatten
;; fjern ugyldige

(flatten small)

;; naboer til 6-index:

(def left dec)
(def right inc)
(defn up [x]   


;; moves
;; (0,0) is upper left corner. First element X horizontal axis, second Y vertical
(def left [dec identity])
(def right [inc identity])
(def up [identity dec])
(def down [identity inc])

;; parents
;; how did we get to this point?
(def two-ways [left up])
(def three-ways [left up down])
(def four-ways [left up down right])

;; all coords
(def all-coords (for [x (range 5) y (range 5)] [x y]))

;; coordinate of single parent
(defn transform-coord [coord move]
  (map #(%1 %2) move coord))

;; get the coordinates of all parents
(defn parents-coords [coordinate parents]
  (map (partial transform-coord coordinate) parents))

(def max 5)

;;; legality
(defn legal-index [idx]
  (not (or (neg? idx) (>= idx max))))

(defn legal? [coords]
  (not-any? false? (map legal-index coords)))

;; remove parents "out-of-bounds"
(defn illegal-parents [parents-coords]
  (filter legal? parents-coords))





;; (defn nei-idx [x y max]
;;   (map #(list (transform-idx x (first %) max) (transform-idx y (second %) max)) two-way)) 

;; (defn nei-idx-singe [[x y] [tx ty]]
;;   (list x y tx ty))
;; better: filter for val neg? and val > max


;; only non-null values
;; memoize org table get-val
;; memoize neighbours at point

;; (defn get-val [coll x y]
;;   (nth (nth coll y) x))

;; (defn nei-vals [coll x y]
;;   (map #(get-val coll (first %) (second %)) (nei-idx x y)))