(ns adventofcode2017.core
  (:gen-class)
  (:require [adventofcode2017.day1]
            [adventofcode2017.day2]
            [adventofcode2017.day3]
            [adventofcode2017.day4]
            [adventofcode2017.day5]))

(def max-solutions 6)

(def solutions 
  (->>  (range 1 max-solutions)
        (map #(symbol (str "adventofcode2017.day" %) "solution"))))

(defn -main [& args]
  (dorun (map #(@(resolve %)) solutions))
  (println "done!"))
