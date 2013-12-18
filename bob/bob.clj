(ns bob (:require [clojure.string :as str]))

(defn upper-case? [character]
  (= (str/upper-case character) character))

(defn yelling? [input]
  (let [characters (re-seq #"[a-zA-Z]" input)]
    (and characters (every? upper-case? characters))))

(defn question? [input]
  (and (.endsWith input "?") (not (yelling? input))))

(defn response-for [input]
  (cond (str/blank? input) "Fine. Be that way!"
        (question? input) "Sure."
        (yelling? input) "Woah, chill out!"
        :else "Whatever."))
