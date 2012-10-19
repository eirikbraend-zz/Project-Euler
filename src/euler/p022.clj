(ns euler.p022)

(def file "resources/p022-input.txt")

(defn split [line]
  (clojure.string/split (clojure.string/replace line #"\"" "") #","))

(defn calc-score [idx name]
  (* (inc idx) (reduce + (map #(- (int %) 64) (seq name)))))

(reduce + (map-indexed calc-score (->> file slurp split sort)))

;; 871198282