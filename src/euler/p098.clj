;;; Anagramic squares

;; By replacing each of the letters in the word CARE with 1, 2, 9, and
;; 6 respectively, we form a square number: 1296 = 362. What is
;; remarkable is that, by using the same digital substitutions, the
;; anagram, RACE, also forms a square number: 9216 = 962. We shall
;; call CARE (and RACE) a square anagram word pair and specify further
;; that leading zeroes are not permitted, neither may a different
;; letter have the same digital value as another letter. Using
;; words.txt, a 16K text file containing nearly two-thousand common
;; English words, find all the square anagram word pairs (a
;; palindromic word is NOT considered to be an anagram of itself).
;; What is the largest square number formed by any member of such a
;; pair? NOTE: All anagrams formed must be contained in the given text
;; file.

(ns euler.p098
  (:require [clojure.string :as str]
            [clojure.math.numeric-tower :as math]
            [clojure.math.combinatorics :as combo]))

(def input "resources/p098-input.txt")

(defn parse-file [file-name]
  (-> file-name slurp (str/replace "\"" "") (str/split #",")))

(defn anagrams [words]
  (let [same-chars (vals (group-by (comp frequencies seq) words))]
    (filter #(> (count %) 1) same-chars)))

(def all-anagrams
  (-> input parse-file anagrams))

(def digits (range 10))

(combo/permutations [1 2 3])
(math/sqrt 9)
(combo/combinations [1 2 3] 2)

(def select (map #(combo/combinations digits %) (range 2 10)))

(defn my-perm [n]
  (combo/combinations digits n))
;; find the number of unique letters in word - n
;; NB zeros IS allowed, but not leading!
;; find all ways to select n from 9 elements
;; permutate all those elements
;; apply to all anagrams
;; check if square

;; start with care/race
;;    (filter #(> ( count %) 1) same-chars)))
