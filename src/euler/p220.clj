(ns euler.p220)

;; Let D0 be the two-letter string "Fa". For n1, derive Dn from Dn-1 by the string-rewriting rules:

;; "a"  "aRbFR"
;; "b"  "LFaLb"

;; Thus, D0 = "Fa", D1 = "FaRbFR", D2 = "FaRbFRRLFaLbFR", and so on.

;; Then Dn is an exotic drawing known as the Heighway Dragon of order n. 
;; For example, D10 is shown below; counting each "F" as one step, the highlighted spot at (18,16) is the position reached after 500 steps.

;; What is the position of the cursor after 1012 steps in D50 ?
;; Give your answer in the form x,y with no spaces.


(def start-term "Fa")
(def a (seq "aRbFR"))
(def b (seq "LFaLb"))
(def replace-map { \a a, \b b})

(defn my-replace [input] (replace { \a a, \b b} input))

(defn rewrite [n start-term]
  (loop [idx 0, res (seq start-term)]
    (if (= idx n)
      (apply str res)
      (recur (inc idx) (take 2000 (flatten (replace replace-map res)))))))

;(reduce path seed a)
;; NB only count F as steps!!
;; must increase/calculate length of dragon

(def r-turn {:N :E, :E :S, :S :W, :W :N})
(def l-turn {:N :W, :E :N, :S :E, :W, :S})
(def f-step {:N [1, 0], :E [0, 1], :S [-1, 0], :W [0, -1]})
(def seed {:coord [0 0], :dir :N})

(defn path [p n]
  (cond 
   (= n \R) (assoc p :dir (r-turn (p :dir)))
   (= n \L) (assoc p :dir (l-turn (p :dir)))
   (= n \F) (assoc p :coord (map + (p :coord) (f-step (p :dir))))
   :else p
   ))

;; reduce: x, y, dir