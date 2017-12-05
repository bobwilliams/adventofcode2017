; --- Day 1: Inverse Captcha ---

; The night before Christmas, one of Santa's Elves calls you in a panic. "The printer's broken! We can't print the Naughty or Nice List!" By the time you make it to sub-basement 17, there are only a few minutes until midnight. "We have a big problem," she says; "there must be almost fifty bugs in this system, but nothing else can print The List. Stand in this square, quick! There's no time to explain; if you can convince them to pay you in stars, you'll be able to--" She pulls a lever and the world goes blurry.

; When your eyes can focus again, everything seems a lot more pixelated than before. She must have sent you inside the computer! You check the system clock: 25 milliseconds until midnight. With that much time, you should be able to collect all fifty stars by December 25th.

; Collect stars by solving puzzles. Two puzzles will be made available on each day millisecond in the advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

; You're standing in a room with "digitization quarantine" written in LEDs along one wall. The only door is locked, but it includes a small interface. "Restricted Area - Strictly No Digitized Users Allowed."

; It goes on to explain that you may only leave by solving a captcha to prove you're not a human. Apparently, you only get one millisecond to solve the captcha: too fast for a normal human, but it feels like hours to you.

; The captcha requires you to review a sequence of digits (your puzzle input) and find the sum of all digits that match the next digit in the list. The list is circular, so the digit after the last digit is the first digit in the list.

; For example:

; 1122 produces a sum of 3 (1 + 2) because the first digit (1) matches the second digit and the third digit (2) matches the fourth digit.
; 1111 produces 4 because each digit (all 1) matches the next.
; 1234 produces 0 because no digit matches the next.
; 91212129 produces 9 because the only digit that matches the next one is the last digit, 9.

; What is the solution to your captcha?

; --- Part Two ---

; You notice a progress bar that jumps to 50% completion. Apparently, the door isn't yet satisfied, but it did emit a star as encouragement. The instructions change:

; Now, instead of considering the next digit, it wants you to consider the digit halfway around the circular list. That is, if your list contains 10 items, only include a digit in your sum if the digit 10/2 = 5 steps forward matches it. Fortunately, your list has an even number of elements.

; For example:

; 1212 produces 6: the list contains 4 items, and all four digits match the digit 2 items ahead.
; 1221 produces 0, because every comparison is between a 1 and a 2.
; 123425 produces 4, because both 2s match each other, but no other digit has a match.
; 123123 produces 12.
; 12131415 produces 4.

; What is the solution to your new captcha?


(ns adventofcode2017.day1
  (:gen-class))

(def input "9513446799636685297929646689682997114316733445451534532351778534251427172168183621874641711534917291674333857423799375512628489423332297538215855176592633692631974822259161766238385922277893623911332569448978771948316155868781496698895492971356383996932885518732997624253678694279666572149831616312497994856288871586777793459926952491318336997159553714584541897294117487641872629796825583725975692264125865827534677223541484795877371955124463989228886498682421539667224963783616245646832154384756663251487668681425754536722827563651327524674183443696227523828832466473538347472991998913211857749878157579176457395375632995576569388455888156465451723693767887681392547189273391948632726499868313747261828186732986628365773728583387184112323696592536446536231376615949825166773536471531487969852535699774113163667286537193767515119362865141925612849443983484245268194842563154567638354645735331855896155142741664246715666899824364722914296492444672653852387389477634257768229772399416521198625393426443499223611843766134883441223328256883497423324753229392393974622181429913535973327323952241674979677481518733692544535323219895684629719868384266425386835539719237716339198485163916562434854579365958111931354576991558771236977242668756782139961638347251644828724786827751748399123668854393894787851872256667336215726674348886747128237416273154988619267824361227888751562445622387695218161341884756795223464751862965655559143779425283154533252573949165492138175581615176611845489857169132936848668646319955661492488428427435269169173654812114842568381636982389224236455633316898178163297452453296667661849622174541778669494388167451186352488555379581934999276412919598411422973399319799937518713422398874326665375216437246445791623283898584648278989674418242112957668397484671119761553847275799873495363759266296477844157237423239163559391553961176475377151369399646747881452252547741718734949967752564774161341784833521492494243662658471121369649641815562327698395293573991648351369767162642763475561544795982183714447737149239846151871434656618825566387329765118727515699213962477996399781652131918996434125559698427945714572488376342126989157872118279163127742349")

(defn count-em [n d]
  (->>  (filter #(= (first %) (last %)) d)
        (map first) 
        (map #(* (Character/digit % 10) n))
        (reduce +)))

(defn solution []
  (let [part1 (->>  (partition 2 1 [(first input)] input)
                    (count-em 1))
        part2 (->>  (partition (+ 1 (/ (count input) 2)) 1 input)
                    (count-em 2))]
    (println part1)
    (println part2)))