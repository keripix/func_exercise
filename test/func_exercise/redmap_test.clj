(ns func-exercise.redmap_test
  (:require [clojure.test :refer :all]
            [func-exercise.redmap :refer :all]))


(deftest test-redmap
  (is (= [1 2 3 4] (redmap #(inc %) [0 1 2 3]))))