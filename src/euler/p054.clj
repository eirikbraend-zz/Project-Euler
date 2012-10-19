(ns euler.p054
  (:require [clojure.string :as str]))

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

(def file "resources/p054-input.txt")

(defn one-pair [hand]
  
  )

(defn slurp-n-split [file]
  (map #(str/split % #" ") (str/split-lines (slurp file))))


(slurp-n-split file)


