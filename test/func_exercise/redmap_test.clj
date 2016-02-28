(ns func-exercise.redmap_test
  (:require [clojure.test :refer :all]
            [clojure.core :refer :all]))

(defn mapping_using_reduce
  [fn coll]
  (reduce #(conj (vec %1) (fn %2)) [] coll))

(deftest test-redmap
         "implementing map with reduce"
         (is (= [1 2 3 4]
                (reduce (fn [x y]
                            (if (coll? x)                   ; when the first argument does not implement IPersistentCollection, then we can asume that we are iterating on the first 2 items
                              (conj (vec x) (inc y))        ;
                              (vector (inc x) (inc y))))    ; creating a vector with x and y after applying inc function to both of them
                        [0 1 2 3])
                ))
         "abstracting the above steps to a function"
         (is (= [1 2 3 4] (mapping_using_reduce #(inc %1) [0 1 2 3]))))
