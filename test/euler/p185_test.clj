(ns euler.p185-test
  (:use euler.p185)
  (:use clojure.test))

(defn check11 [val]
  (println "VAL" val)
  (< (count val) 3))

(deftest antall-riktige-test
  (is (= 2 (antall-riktige "90342" "39542")))
  (is (= 0 (antall-riktige "70794" "39542")))
  (is (= 2 (antall-riktige "39458" "39542")))
  (is (= 1 (antall-riktige "34109" "39542")))
  (is (= 2 (antall-riktige "51545" "39542")))
  (is (= 1 (antall-riktige "12531" "39542")))
  )

(deftest gen-test
  (is (= '(10 0 0) (gen check11))))

(deftest checks-test
  (is ()))