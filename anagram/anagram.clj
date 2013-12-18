(ns anagram)

(defn charfreq [w]
  (frequencies (map clojure.string/lower-case (re-seq #"[\w]" w))))

(defn anagramatic? [x y]
  (and (not= x y)
       (= (charfreq x) (charfreq y))))

(defn anagrams-for [w l]
  (filter #(anagramatic? % w) l))
