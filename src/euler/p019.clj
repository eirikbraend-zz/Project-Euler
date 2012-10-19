(ns euler.p019)

;1 Jan 1900 was a Monday.
;Thirty days has September,
;April, June and November.
;All the rest have thirty-one,
;Saving February alone,
;Which has twenty-eight, rain or shine.
;And on leap years, twenty-nine.
;A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
;How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

(defn divisible? [dividend divisor]
  (zero? (mod dividend divisor)))

(defn leap-year? [year]
  (and 
    (divisible? year 4) 
    (or 
      (not (divisible? year 100))
      (divisible? year 400))))

(defn month-dates [days]
  (range 1 (inc days)))
  
(defn create-dates [year]
  (concat
    (month-dates 31)
    (month-dates (if (leap-year? year)
                   29
                   28))
    (month-dates 31) 
    (month-dates 30) 
    (month-dates 31) 
    (month-dates 30) 
    (month-dates 31) 
    (month-dates 31) 
    (month-dates 30) 
    (month-dates 31) 
    (month-dates 30) 
    (month-dates 31)))

(def century (mapcat create-dates (range 1901 2001)))

(def foo (nthrest century 5))

(def bar (take-nth 7 foo))
(filter #(= 1 %) bar)
(count (filter #(= 1 %) bar))
;; 171

;;36525
