(ns func-exercise.redfilter-test
    (:require [clojure.test :refer :all]
      [clojure.core :refer :all]))

(defn filter_with_reduce
      [fn coll]
      (reduce #(if (fn %2) (conj %1 %2) %1) [] coll)
      )
(def food-journal
  [{:month 1 :day 1 :human 5.3 :critter 2.3}
   {:month 1 :day 2 :human 5.1 :critter 2.0}
   {:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 2 :day 2 :human 5.0 :critter 2.5}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   {:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 4 :day 2 :human 3.7 :critter 3.6}])

(def food-journal-result
  [{:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   {:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 4 :day 2 :human 3.7 :critter 3.6}])


(deftest test-filter-with-reduce
         "first attempt to implement filter with reduce"
         (is (= [0 1 2 3 4]
                (filter_with_reduce #(> 5 %1) [0 1 2 3 4 5 6 7 8 9])))
         "now using the example in brave clojure"
         (is (= food-journal-result (filter_with_reduce #(< (:human %) 5) food-journal)))
         )
