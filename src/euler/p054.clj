(ns euler.p054
  (:require [clojure.string :as str] [clojure.math.numeric-tower :as math]))

;n the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:
;
;High Card: Highest value card.
;One Pair: Two cards of the same value.
;Two Pairs: Two different pairs.
;Three of a Kind: Three cards of the same value.
;Straight: All cards are consecutive values.
;Flush: All cards of the same suit.
;Full House: Three of a kind and a pair.
;Four of a Kind: Four cards of the same value.
;Straight Flush: All cards are consecutive values of same suit.
;Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
;The cards are valued in the order:
;2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.

(def input-file "resources/p054-input.txt")

(defn slurp-n-split [file]
  (map #(str/split % #" ") (str/split-lines (slurp file))))

(def rank-replacement { \T "10", \J "11", \Q "12", \K "13", \A "14"})
(def suit-replacement { \H :H, \C :C, \S :S, \D :D})

(defn transform-card [card]
  (let [[rank suit] (seq card)]
    [(-> (rank-replacement rank rank) str read-string dec) (suit-replacement suit suit)]))

(def transformed-input (map #(map transform-card %) (slurp-n-split input-file)))

(def base 13)
(def size-hand 5)
(def weights (map math/expt (repeat size-hand base) (range 0 size-hand)))

(defn sort-n-split [siffer] 
  (sort-by count (partition-by identity (sort (seq siffer)))))

(def tmp (take 5 (second transformed-input)))
(sort-n-split (map first tmp))

;;(-> (sort-n-split en-lik) flatten)

