(ns euler.p185
  (:use clojure.math.combinatorics))


(def fasit "39542")

(def small [
            ["90342" 2]
            ["70794" 0]
            ["39458" 2]
            ["34109" 1]
            ["51545" 2]
            ["12531" 1] 
            ])

(def lista (map #(% 0) small))

;;;;;;;;;;;;;;;;
;; må ha flere avskjæringer:

;; NB antall gjenværende kolonner sett mot antall manglende "riktige"
;; NB må være sikker på at tallet finnes i kolonne!!
;; NB Ikke glem sum pr rad også! (dvs ingen videre tall er riktige)
; tell antall riktige i mottatt sekvens
; hvor hver gjenværende kolonne: finn antall forekomster av vanligste tall
; summer disse
; hvis denne summen pluss antall riktige er større enn summen av "fasit" -ok, elles ingen løsning.
;;;;;;;;;;;;;;;;;;

;; finn max antall riktige i "resten"
;; strip n først tegn i "fasit". tell max i hver kol og summer)
;; finn antall ritige på guess

(defn antall-riktige [seq1 seq2]
  (count (filter true? (map = (seq seq1) (seq seq2)))))

(defn sjekk-antall [seq1 seq2 num] 
  (- (antall-riktige seq1 seq2) num))

(defn foo [guess sekvenser]
  (map #(antall-riktige guess %) sekvenser)
  )

(defn sum-antall-riktige [guess sekvenser]
  (reduce + (foo guess sekvenser)))


;;start på x i pos y, sjekk om kan være løsning:
;; ja: neste index y + 1, repeat
;; nei: hvis x == 9, gå tilbake y - 1, prøv x + 1 , dvs return 
;;      ellers prøv x + 1
;; detalj: pos kan utledes av lengden på seq

(defn gyl [seq] 
  (let [pre (apply str seq)]
    pre
    )
  )

(defn gyldig [val pos]
  (or (and (= pos 0) (= val 4))
      (and (= pos 1) (= val 6))))
   
(defn foor [sjekk]
  (loop [val 0, pos 0, seq ()]
  
    (cond 
      
      (sjekk val pos) 
      (do
        (println "første " (list val pos seq))  
        (recur 0 (inc pos) (cons val seq))
        )
      
      (< val 10)
      (do
        (println "andre" (list val pos seq))
        (recur (inc val) pos seq)
        )
      
      :else seq
      )))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


;; gitt "small"
;; when guess 9
;; then
;; sum-antall riktige = 1
;; sum manglede tall = sum alle tall - 1 = 7
;; rad 2 - 0 - 2
;; rad 3 - 5 - 2
;; rad 4 - 4 - 2
;; rad 5 - 2 - 1
;; sum = 7, ok, perm vidre.

;; when guest "90"
;; then sum-antall riktige = 3
;; rad 3 - 5 - 2
;; rad 4 - 4 - 2
;; rad 5 - 2 - 1
;; sum 5 -ok

;; when guest "905"
;; then sum-antall riktige = 5
;; rad 4 - 4 - 2
;; rad 5 - 2 - 1
;; sum 5 -ok
;; 90541 wtf=


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

