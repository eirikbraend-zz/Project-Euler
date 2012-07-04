(ns euler.p185
  (:use clojure.math.combinatorics))

;(def perm (clojure.math.combinatorics/selections (range 10) 3))

;(def gjett {
;            "90342" 2
;            "70794" 0
;            "39458" 2 
;            "34109" 1 
;            "51545" 2 
;            "12531" 1 
;            })

;(def fasit "39542")

;; AVSKJÆRINGER:
;; permuter med mest frekvente tall først for å avskjære tidlig
;; sjekk både begynnelse og slutt
;; for slutt: når bare x plasser igjen og y riktige så langt, sammestill flere og avskjær.
;; Ikke permuter over tall som IKKE kan være riktig, ref 0 riktige i raden.

(def input [
             ["1748270476758276" 3]
             ["1841236454324589" 3]
             ["2321386104303845" 0]
             ["2326509471271448" 2]
             ["2615250744386899" 2]
             ["2659862637316867" 2]
             ["3041631117224635" 3]
             ["3174248439465858" 1]
             ["3847439647293047" 1]
             ["4296849643607543" 3]
             ["4513559094146117" 2]
             ["4895722652190306" 1]
             ["5251583379644322" 2]
             ["5616185650518293" 2]
             ["5855462940810587" 3]
             ["6375711915077050" 1]
             ["6442889055042768" 2]
             ["6913859173121360" 1]
             ["7890971548908067" 3]
             ["8157356344118483" 1]
             ["8690095851526254" 3]
             ["9742855507068353" 3]
             ])

(defn tell-antall-like [a b]
  (count (filter true? (map = a b))))

(defn yet-another [[value num] check]
  (- (tell-antall-like value check) num))

(defn foo [x]
  (map yet-another input (repeat 22 x))
  )

(defn bar [x]
  (filter pos? (foo x)))

