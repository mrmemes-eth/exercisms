(ns dna)

(defn nucleotide-count [nucleotide strand]
  (if (re-find #"^[GATCU]+$" (str nucleotide))
      (count (re-seq (re-pattern (str nucleotide)) strand))
      (throw (Exception. "invalid nucleotide"))))

(defn nucleotide-counts [strand]
  (reduce
    (fn [hsh nucleotide]
      (conj hsh { nucleotide (nucleotide-count nucleotide strand) }))
    {}
    '(\A \T \C \G)))
