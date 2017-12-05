; A new system policy has been put in place that requires all accounts to use a passphrase instead of simply a password. A passphrase consists of a series of words (lowercase letters) separated by spaces.

; To ensure security, a valid passphrase must contain no duplicate words.

; For example:

; aa bb cc dd ee is valid.
; aa bb cc dd aa is not valid - the word aa appears more than once.
; aa bb cc dd aaa is valid - aa and aaa count as different words.
; The system's full passphrase list is available as your puzzle input. How many passphrases are valid?


(ns adventofcode2017.day4
  (:gen-class)
  (:require [clojure.string :as s]))

(def input-file "src/adventofcode2017/day4_input.txt")
(def input (s/split-lines (slurp input-file)))

(defn solution []
  (->>  (map #(s/split % #" ") input)
        (map #(apply distinct? %))
        (filter true?)
        (count)
        (println)))