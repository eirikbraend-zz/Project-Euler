(ns euler.p067)

(def input (slurp "resources/p067-input.txt"))

; slurp
; split-lines
; split on space
; map list
; to integer bigint

(-> input clojure.string/split-lines (map #(clojure.string/split % " ")))