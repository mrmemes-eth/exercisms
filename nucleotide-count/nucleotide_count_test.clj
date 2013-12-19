(ns nucleotide-count.test (:require [clojure.test :refer :all]))
(load-file "dna.clj")

(deftest empty-dna-strand-has-no-adenosine
  (is (= 0 (dna/nucleotide-count \A, ""))))

(deftest empty-dna-strand-has-no-nucleotides
  (is (= {\A 0, \T 0, \C 0, \G 0}
         (dna/nucleotide-counts ""))))

(deftest repetitive-cytidine-gets-counted
  (is (= 5 (dna/nucleotide-count \C "CCCCC"))))

(deftest repetitive-sequence-has-only-guanosine
  (is (= {\A 0, \T 0, \C 0, \G 8}
         (dna/nucleotide-counts "GGGGGGGG"))))

(deftest counts-only-thymidine
  (is (= 1 (dna/nucleotide-count \T "GGGGGTAACCCGG"))))

(deftest dna-has-no-uracil
  (is (= 0 (dna/nucleotide-count \U "GATTACA"))))

(deftest validates-nucleotides
  (is (thrown-with-msg? Exception #"invalid nucleotide" (dna/nucleotide-count \X "GACT"))))

(deftest counts-all-nucleotides
  (let [s "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"]
    (is (= {\A 20, \T 21, \G 17, \C 12}
           (dna/nucleotide-counts s)))))

(run-tests)
