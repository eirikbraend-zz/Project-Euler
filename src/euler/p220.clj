(ns euler.p220)

;; Let D0 be the two-letter string "Fa". For n1, derive Dn from Dn-1 by the string-rewriting rules:

;; "a"  "aRbFR"
;; "b"  "LFaLb"

;; Thus, D0 = "Fa", D1 = "FaRbFR", D2 = "FaRbFRRLFaLbFR", and so on.

;; Then Dn is an exotic drawing known as the Heighway Dragon of order n. 
;; For example, D10 is shown below; counting each "F" as one step, the highlighted spot at (18,16) is the position reached after 500 steps.

;; What is the position of the cursor after 1012 steps in D50 ?
;; Give your answer in the form x,y with no spaces.


;; "a"  "aRbFR"
;; "b"  "LFaLb"


;; "a"  "aRbFR"
;; "b"  "LFaLb"

(def start-term "Fa")
(def a (seq "aRbFR"))
(def b (seq "LFaLb"))
(def replace-map { \a a, \b b})

(defn my-replace [input] (replace { \a a, \b b} input))

(defn rewrite [n start-term]
  (loop [idx 0, res (seq start-term)]
    (if (= idx n)
      (apply str res)
      (recur (inc idx) (flatten (replace replace-map res))))))

;;"FaRbFRRLFaLbFR"
;; FaRbFRRLFaLbFR
FaRbFRRLFaLbFRRLFaRbFRLLFaLbFR


;; "a"  "aRbFR"
;; "b"  "LFaLb"

FaRbFRR     FRRLF     L     FRRLFaRbFRLLFaLbFRRLFaRbFRRLFaLbFRLLFaRbFRLLFaLbFR
FaRbFRRLFaLbFRRLFaRbFRLLFaLbFRRLFaRbFRRLFaLbFRLLFaRbFRLLFaLbFRRLFaRbFRRLFaLbFRRLFaRbFRLLFaLbFRLLFaRbFRRLFaLbFRLLFaRbFRLLFaLbFR
FaRbFRRLFaLbFRRLFaRbFRLLFaLbFRRLFaRbFRRLFaLbFRLLFaRbFRLLFaLbFRRLFaRbFRRLFaLbFRRLFaRbFRLLFaLbFRLLFaRbFRRLFaLbFRLLFaRbFRLLFaLbFRRLFaRbFRRLFaLbFRRLFaRbFRLLFaLbFRRLFaRbFRRLFaLbFRLLFaRbFRLLFaLbFRLLFaRbFRRLFaLbFRRLFaRbFRLLFaLbFRLLFaRbFRRLFaLbFRLLFaRbFRLLFaLbFR
