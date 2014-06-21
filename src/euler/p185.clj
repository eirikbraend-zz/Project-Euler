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

(def colums (apply map vector (map seq (map first small))))


(def lista (map first small))

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

;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;


(defn antall-riktige [seq1 seq2]
  (count (filter true? (map = (seq seq2) (seq seq1)))))

(defn sjekk-antall [seq1 seq2 num] 
  (- (antall-riktige seq1 seq2) num))

(defn foo [guess sekvenser]
  (map #(antall-riktige guess %) sekvenser)
  )

(defn sum-antall-riktige [guess sekvenser]
  (reduce + (foo guess sekvenser)))

;;;;;;;;;;;
(defn check-1 [data guess]
  (list data guess))

(defn check-2 [data guess]
  (repeat 2 data))

(defn checks [data & checks]
  (apply juxt (map #(partial % data) checks)))


(def sjekkene (checks "123" check-1 check-2))

;;;;;;;;;;;

(defn generate [check, data]
  (loop [value 0, position 0, solution ()]
    (cond
      (check value position data) (recur 0 (inc position) (cons value solution))
      (< value 10) (recur (inc value) position solution)
      :else (apply str (reverse solution))
      )))

(defn match? [input guess]
  (every? true?
          (map = 
               (map (partial antall-riktige guess) (map first input))
               (map second input))))

(defn fasit? [input]
  (map = ())
  )


(defn gen [check match]
  (loop [candidate [0]]
    (let [[fir & res] candidate]
      (cond
        (match (apply str (reverse candidate)))
        candidate
        (check candidate)
        (do
          (println "check:" candidate)
          (recur (cons 0 candidate)))
        (< fir 10)
        (do
          (println "< 10" candidate)
          (recur (cons (inc fir) res)))
        
        :else candidate))))

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
