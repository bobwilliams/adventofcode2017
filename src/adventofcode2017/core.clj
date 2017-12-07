(ns adventofcode2017.core
  (:gen-class)
  (:require [adventofcode2017.day1 :as day1]
            [adventofcode2017.day2 :as day2]
            [adventofcode2017.day3 :as day3]
            [adventofcode2017.day4 :as day4]
            [adventofcode2017.day5 :as day5]))

(defn -main [& args]
  (day1/solution)
  (day2/solution)
  (day3/solution)
  (day4/solution)
  (day5/solution)
  (println "done!"))