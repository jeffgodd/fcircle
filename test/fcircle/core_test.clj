(ns fcircle.core-test
  (:require [clojure.test :refer :all]
            [fcircle.core :refer :all]))

(deftest primes-test
  (let [real-primes [2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101 103 107 109 113 127 131 
                     137 139 149 151 157 163 167 173 179 181 191 193 197 199]
        my-primes (get-primes 46)]
    (testing "get-primes must deliver more than 10 primes"
      (is (= my-primes real-primes) "get-primes has failed"))

    (testing "primes must be primes"
      (is (= (count my-primes) (count (filter #(prime? %) real-primes))) "primes filter function has missed a real one"))

    (testing "not primes must not be primes"
      (is (= 0 (count (filter #(prime? %) [ 4 6 8 10 20 45 99]))) "primes filter function failed to reject a non-prime"))))
    
(deftest print-tests
  (testing "format-cell should make 1 into spaces according to size "
    (is (= (format-prime-cell 1 10) "          ") "formatting doesn't make sense"))

  (testing "row format prints cleanly"
    (is (= (multiplication-print-row [34 44] 6) "    34    44"))))

(deftest input-test
  (testing "inputs can be parsed to ints"
    (is (thrown? NumberFormatException (clean-input ["aa" "integer"])) "Failed to catch you ignoring directions.")))
