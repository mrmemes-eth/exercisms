(ns etl)

(defn translate-entry  [[score letters]]
  (zipmap
    (map clojure.string/lower-case letters)
    (repeat score)))

(defn transform [db]
  (into {} (map #(translate-entry %) db)))
