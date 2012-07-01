(ns euler.p185
  (:use clojure.math.combinatorics))

(clojure.math.combinatorics/selections (range 10) 2)

(defn antall-riktige [x y]
   (count (filter true? (map = x y))))

(def gjett2 ["90342" "70794" "39458" "34109" "51545" "12531"])

(def gjett {
            "90342" 2
            "70794" 0
            "39458" 2 
            "34109" 1 
            "51545" 2 
            "12531" 1 
            })

(def fasit "39542")


(filter #(= 2 %)  (map #(antall-riktige % fasit) (map #(apply str %) foo)))



;; AVSKJÆRINGER:
;; permuter med mest frekvente tall først for å avskjære tidlig
;; sjekk både begynnelse og slutt
;; for slutt: når bare x plasser igjen og y riktige så langt, sammestill flere og avskjær.
;; Ikke permuter over tall som IKKE kan være riktig, ref 0 riktige i raden.

(def gjett3 {
             "5616185650518293" 2 
             "3847439647293047" 1 
             "5855462940810587" 3 
             "9742855507068353" 3
             "4296849643607543" 3 
             "3174248439465858" 1 
             "4513559094146117" 2 
             "7890971548908067" 3 
             "8157356344118483" 1 
             "2615250744386899" 2 
             "8690095851526254" 3 
             "6375711915077050" 1 
             "6913859173121360" 1 
             "6442889055042768" 2 
             "2321386104303845" 0 
             "2326509471271448" 2 
             "5251583379644322" 2 
             "1748270476758276" 3 
             "4895722652190306" 1 
             "3041631117224635" 3 
             "1841236454324589" 3 
             "2659862637316867" 2 
             })

(count (keys gjett3))
(def gjett3-snudd (partition (count (keys gjett3)) (apply interleave (keys gjett3))))
(def g3 (map #(apply str %) gjett3-snudd))

(def null-riktige (filter #(= 0 (val %)) gjett3))

