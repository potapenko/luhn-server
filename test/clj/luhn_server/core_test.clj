(ns luhn-server.core-test
  (:require [clojure.test :refer :all]
            [luhn-server.luhn :as l]))

(deftest valid-test
  (is (= true (l/valid-string? "1111")))
  (is (= true (l/valid-string? "1111 222 333")))
  (is (= true (l/valid-string? "111k22")))
  (is (= false (l/digits? "111k22")))
  (is (= true (l/digits? "1113333")))
  (is (= [2 2 7 4] (l/double-other [1 2 8 4])))
  (is (= true (l/valid? 49927398716)))
  (is (= false (l/valid? 79927398710)))
  (is (= true (l/valid? "4539 1488 0343 6467")))
  (is (= false (l/valid? "8273 1232 7352 0569")))
  (is (= true (l/valid? "7253 2262 5312 0539")))

  )

