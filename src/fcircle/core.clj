(ns fcircle.core
  (:gen-class))

(defn prime?
  "brute force method - one factor will be >= the sqrt of x"
  [x]
  (loop [factor-max (Math/sqrt x)
        pass 2]
    (if (> pass factor-max)
      true
      (if (= 0 (mod x pass))
        false
        (recur factor-max (inc pass))))))

(defn lazy-odds
  ([] (lazy-odds 3))
  ([x] (lazy-seq (cons x (lazy-odds (+ 2 x))))))

(defn get-primes
  "returns a sequence of primes of the specified length"
  [length]
  (take length (cons 2 (filter #(prime? %) (lazy-odds)))))

(defn format-prime-cell
  "gets rid of the convenient non-prime 1"
  [cell size]
  (if (= cell 1)
    (format (str "%" size "s") "")
    (format (str "%" size "d") cell)))

(defn multiplication-print-row
  [row cell-size]
   (apply str (map #(format-prime-cell % cell-size) row)))

(defn multiplication-table
  "prints a multiplication table of the provded vector"
  [arg]
  (let [bg (last arg)
        biggest (count (str (* bg bg)))
        cell-size (+ 3 biggest)]
    (doseq [x arg]
      (let [row (map #(* % x) arg)]
        (print (multiplication-print-row row cell-size) "\n")))))

(defn clean-input
  [args]
  (let [size (try (Integer/parseInt (first args))
                  (catch NumberFormatException e
                    (println "Please enter an integer.  An integer followed by \"integer\" provides a decimals table.  Try again.")
                    (throw e))) ;throwing e because I wanted the test to catch the exception....
        primes (get-primes size)
        table-input (if (= "integer" (second args))
                      #(range 1 (inc size))
                      #(cons 1 primes))]
    (when size (multiplication-table (table-input)))))

(defn -main
  "Its a fun little coding thing"
  [& args]
  (if args
    (clean-input args)
    (let [_ (println "Please enter the number of columns. Add \"integer\" for decimals: ")
          input (read-line)
          inp (clojure.string/split input #"\s")]
      (clean-input inp))))
