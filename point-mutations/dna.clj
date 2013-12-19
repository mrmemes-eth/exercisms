(ns dna)

(defn hamming-distance [origin comparison]
  (count
    (filter (fn [[o c]] (not= o c))
            (partition 2 (interleave origin comparison)))))
