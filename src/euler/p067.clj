(ns euler.p067
  (:use [euler.utils :as util])
  (:use [euler.p018 :as bar])
  (:require [clojure.string :as str])
  (:import [java.lang Integer]))

(def input3 (slurp "resources/p067-input.txt"))

(def splitted-lines (str/split-lines input3))

(defn split-line [line]
  (str/split line #" "))

(def foo (map split-line splitted-lines))

(def input2 (map #(map util/parse-int %) foo))

;; 7273
