(ns euler.test.p185
  (:use euler.p185)
  (:use clojure.test))


(deftest tell
  (is (= 2 (antall-riktige "90342" "39542")))
  (is (= 0 (antall-riktige "70794" "39542")))
  (is (= 2 (antall-riktige "39458" "39542")))
  (is (= 1 (antall-riktige "34109" "39542")))
  (is (= 2 (antall-riktige "51545" "39542")))
  (is (= 1 (antall-riktige "12531" "39542")))
  )

