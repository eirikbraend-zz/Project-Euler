(ns euler.p185
  (:use clojure.math.combinatorics))

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

(def verdier (map #(% 0) input))
(def korrekte (map #(% 1) input))

(def snudd (map #(apply str %) (partition 22 (apply interleave verdier))))

(def sort-snudd (map #(apply str (sort %)) snudd))

(defn num-equals [a b]
  (count (filter true? (map = a b))))

(defn diff-to-expected [[value num] check]
  (- (num-equals value check) num))

(defn diff-to-exp-liste [x]
  (map diff-to-expected input (repeat 22 x)))

(defn exceed-expected [x]
  (filter pos? (diff-to-exp-liste x)))


;; permuter over alle tall
;; for hvert element:
   ;;
   ;; nb! må ta hensyn til om tall i det hele tatt er gydlig??? nei, tas av max-treff sjekk

;; finne sum av utestående nummer

;; start med "" tom
;; Ikke permuter over tall som ikke kan stå i kolonne
;; Stopp permutering når minst ett tall gir flere treff enn max
;; Stopp permutering når summen av gjenværende antall treff i hver kolonne er større enn antall siffer som gjenstår
;; å permutere over. Må justeres for like tall i kolonner.

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


