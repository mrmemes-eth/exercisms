(defn letter-chars []
  (map char (range 65 91)))

(defn number-chars []
  (map char (range 48 58)))

(defn lazy-rand [l]
  (repeatedly (fn [] (rand-nth l))))

(defn new-name []
  (apply str
         (concat
           (take 2 (lazy-rand (letter-chars)))
           (take 3 (lazy-rand (number-chars))))))

(defn reset-name [rbt]
 (swap! rbt assoc :name (new-name)))

(defn robot []
    (atom {:name (new-name)}))

(defn robot-name [rbt] (@rbt :name))
