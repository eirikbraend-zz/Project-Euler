(ns euler.p098
  (:require [clojure.string :as str]
            [clojure.math.numeric-tower :as math]))

(def input "resources/p098-input.txt")

(defn parse-file [file-name]
  (-> file-name slurp (str/replace "\"" "") (str/split #",")))

(defn anagrams [words]
  (let [same-chars (vals (group-by (comp frequencies seq) words))]
    (filter #(> ( count %) 1) same-chars)))

