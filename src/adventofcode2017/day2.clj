; --- Day 2: Corruption Checksum ---

; As you walk through the door, a glowing humanoid shape yells in your direction. "You there! Your state appears to be idle. Come help us repair the corruption in this spreadsheet - if we take another millisecond, we'll have to display an hourglass cursor!"

; The spreadsheet consists of rows of apparently-random numbers. To make sure the recovery process is on the right track, they need you to calculate the spreadsheet's checksum. For each row, determine the difference between the largest value and the smallest value; the checksum is the sum of all of these differences.

; For example, given the following spreadsheet:

; 5 1 9 5
; 7 5 3
; 2 4 6 8
; The first row's largest and smallest values are 9 and 1, and their difference is 8.
; The second row's largest and smallest values are 7 and 3, and their difference is 4.
; The third row's difference is 6.
; In this example, the spreadsheet's checksum would be 8 + 4 + 6 = 18.

; What is the checksum for the spreadsheet in your puzzle input?


; --- Part Two ---

; "Great work; looks like we're on the right track after all. Here's a star for your effort." However, the program seems a little worried. Can programs be worried?

; "Based on what we're seeing, it looks like all the User wanted is some information about the evenly divisible values in the spreadsheet. Unfortunately, none of us are equipped for that kind of calculation - most of us specialize in bitwise operations."

; It sounds like the goal is to find the only two numbers in each row where one evenly divides the other - that is, where the result of the division operation is a whole number. They would like you to find those numbers on each line, divide them, and add up each line's result.

; For example, given the following spreadsheet:

; 5 9 2 8
; 9 4 7 3
; 3 8 6 5
; In the first row, the only two numbers that evenly divide are 8 and 2; the result of this division is 4.
; In the second row, the two numbers are 9 and 3; the result is 3.
; In the third row, the result is 2.
; In this example, the sum of the results would be 4 + 3 + 2 = 9.

; What is the sum of each row's result in your puzzle input?

(ns adventofcode2017.day2
    (:gen-class)
    (:require [clojure.math.combinatorics :as combo]))


(def input [[4347  3350  196 162 233 4932  4419  3485  4509  4287  4433  4033  207 3682  2193  4223]
            [648 94  778 957 1634  2885  1964  2929  2754  89  972 112 80  2819  543 2820]
            [400 133 1010  918 1154  1008  126 150 1118  117 148 463 141 940 1101  89]
            [596 527 224 382 511 565 284 121 643 139 625 335 657 134 125 152]
            [2069  1183  233 213 2192  193 2222  2130  2073  2262  1969  2159  2149  410 181 1924]
            [1610  128 1021  511 740 1384  459 224 183 266 152 1845  1423  230 1500  1381]
            [5454  3936  250 5125  244 720 5059  202 4877  5186  313 6125  172 727 1982  748]
            [3390  3440  220 228 195 4525  1759  1865  1483  5174  4897  4511  5663  4976  3850  199]
            [130 1733  238 1123  231 1347  241 291 1389  1392  269 1687  1359  1694  1629  1750]
            [1590  1394  101 434 1196  623 1033  78  890 1413  74  1274  1512  1043  1103  84]
            [203 236 3001  1664  195 4616  2466  4875  986 1681  152 3788  541 4447  4063  5366]
            [216 4134  255 235 1894  5454  1529  4735  4962  220 2011  2475  185 5060  4676  4089]
            [224 253 19  546 1134  3666  3532  207 210 3947  2290  3573  3808  1494  4308  4372]
            [134 130 2236  118 142 2350  3007  2495  2813  2833  2576  2704  169 2666  2267  850]
            [401 151 309 961 124 1027  1084  389 1150  166 1057  137 932 669 590 188]
            [784 232 363 316 336 666 711 430 192 867 628 57  222 575 622 234]])

(defn part1 []
    (let [max-vals (map #(apply max %) input) 
            min-vals (map #(apply min %) input)
            diffs (map #(- %1 %2) max-vals min-vals)]
        (println (reduce + diffs))))

(defn get-vals [c]
  (->> (combo/combinations (sort > c) 2)
       (filter #(= 0 (apply mod %)))
       (flatten)
       (apply /)))

(defn part2[] 
    (println (reduce + (map get-vals input))))

(defn solution []
    (println "day 2...")   
    (part1)
    (part2))
