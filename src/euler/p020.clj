(ns euler.p020
  (:require [euler.utils :as util]))

(reduce + (map #(Integer/parseInt (str %)) (seq (str (util/factorial 100)))))
; 648