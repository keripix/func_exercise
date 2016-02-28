(ns func-exercise.redmap_test
  (:require [clojure.test :refer :all]
            [clojure.core :refer :all]))

(deftest test-redmap
         "implementing map with reduce"
         (is (= [1 2 3 4]
                (reduce (fn [x y]
                            (if (seq? x)
                              ()
                              ()))
                        [0 1 2 3])
                )))