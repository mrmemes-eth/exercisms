(ns phrase)

(defn words [phrase]
  (map clojure.string/lower-case (re-seq #"[\w]+" phrase)))

(defn word-count [phrase]
  (frequencies (words phrase)))
