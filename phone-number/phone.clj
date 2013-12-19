(ns phone)

(defn number [phone-number]
  (let [clean-number (clojure.string/replace phone-number #"\D" "")]
    (cond
      (= (count clean-number) 10) clean-number
      (and
        (= (count clean-number) 11)
        (= (first clean-number) \1))
      (apply str (rest clean-number))
      :else (apply str (take 10 (repeat "0"))))))

(defn area-code [phone-number]
  (apply str (take 3 (number phone-number))))

(defn exchange [phone-number]
  (apply str (take 3 (drop 3 (number phone-number)))))

(defn line-number [phone-number]
  (apply str (drop 6 (number phone-number))))

(defn pretty-print [phone-number]
  (str "(" (area-code phone-number) ")"
       \space (exchange phone-number)
       \- (line-number phone-number)))
