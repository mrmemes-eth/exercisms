(ns school)

(defn grade [db year] (get db year []))

(defn add-student-to-year [db student year]
    (conj db {year (conj (grade db year) student)}))

(defn add [db student year]
  (add-student-to-year db student year))

(defn sorted [db]
  (apply conj
         (map (fn [[k v]] {k (sort v)}) db)))
