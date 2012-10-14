(ns euler.p054
  (:require [clojure.string :as str]))

(def file "resources/p054-input.txt")

(defn slurp-n-split [file]
  (map #(str/split % #" ") (str/split-lines (slurp file))))

