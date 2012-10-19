(ns euler.p025)

; What is the first term in the Fibonacci sequence to contain 1000 digits?

(defn stop [d n]
  (>=  (count (str n)) d))


(defn fibo [stop]
  (loop [f1 (bigint 1), f2 (bigint 1), term 1]
    (if (stop f1)
      term
      (recur f2 (+ f2 f1) (inc term)))))

(fibo (partial stop 1000))

; 4782