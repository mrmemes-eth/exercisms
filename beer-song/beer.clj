(ns beer (:require [clojure.string :refer [capitalize join]]))

(defn bottles-of-beer [number]
  (cond (= number 1) " bottle of beer"
        :else " bottles of beer"))

(defn bottle-word [number]
  (cond (= number 1) " it "
        :else " one "))

(defn bottle-number [number]
  (cond (zero? number) "no more"
        (= number -1) "99"
        :else number))

(defn what-do-you-do [number]
  (cond (zero? number) "Go to the store and buy some more, "
        :else (str "Take"
                   (bottle-word number)
                   "down and pass it around, ")))

(defn verse [number]
  (str (capitalize (bottle-number number))
       (bottles-of-beer number)
       " on the wall, "
       (bottle-number number)
       (bottles-of-beer number)
       ".\n"
       (what-do-you-do number)
       (bottle-number (dec number))
       (bottles-of-beer (dec number))
       " on the wall.\n"))

(defn sing
  ([x] (sing x 0))
  ([x y]
   (apply str (interleave
                (map verse (reverse (range y (inc x))))
                (repeat \newline)))))

