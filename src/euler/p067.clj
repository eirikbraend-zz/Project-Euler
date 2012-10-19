(ns euler.p067
  (:use [euler.utils :as util])
  (:use [euler.p018 :as p018])
  (:require [clojure.string :as str]))

(def file "resources/p067-input.txt")

(defn split-lines-by-space [n]
  (map #(str/split % #" ") n))

(defn parse-lines-int [n]
  (map #(map util/parse-int %) n))

(->> file 
  slurp 
  str/split-lines 
  split-lines-by-space 
  parse-lines-int 
  p018/reducer)

;; 7273
