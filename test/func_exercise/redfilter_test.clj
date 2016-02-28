(ns func-exercise.redfilter-test
    (:require [clojure.test :refer :all]
      [clojure.core :refer :all]))

(defn filter_with_reduce
      [fn coll]
      (reduce #(if (fn %2) (conj %1 %2) %1) [] coll)
      )

(deftest test-filter-with-reduce
         "first attempt to implement filter with reduce"
         (is (= [0 1 2 3 4]
                (filter_with_reduce #(> 5 %1) [0 1 2 3 4 5 6 7 8 9])))
         )
