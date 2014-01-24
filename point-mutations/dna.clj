(ns dna)

(defn hamming-distance [origin comparison]
  (count
    (filter (fn [[o c]] (not= o c))
            (map list origin comparison))))
