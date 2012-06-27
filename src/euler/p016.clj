(ns euler.p016)

; 2 ^ 15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
; What is the sum of the digits of the number 2 ^ 1000?

(reduce + (map #(- (int %) 48) (seq (str (reduce * (repeat 1000 (bigint 2)))))))

; 1366