(ns luhn-server.luhn
  (:require [clojure.string :as str]))

#?(:cljs
   (defn read-string [s]
     (js/parseInt s)))

(defn- str->digits-vec [s]
  (->> s
       (map str)
       (map read-string)
       vec))

(defn double-other [coll]
  (->> coll
       reverse
       (map-indexed
        (fn [idx x]
          (if (-> idx (mod 2) pos?)
            (let [d (* x 2)]
              (if (> d 9)
                (- d 9)
                d))
            x)))
       reverse
       vec))

(defn- sum-all-digits [digits]
  (->> digits (reduce +)))

(defn valid-string? [s]
  (-> s str count (>= 1)))

(defn digits? [s]
  (->> s str (re-find #"^\d+$") nil? not))

(defn valid? [s]
  (when s
   (let [s (str/replace (str s) #"\s+" "")]
     (and (valid-string? s)
          (digits? s)
          (-> s
              str->digits-vec
              double-other
              sum-all-digits
              (mod 10)
              zero?)))))

(comment

  (valid? "7253 2262 5312 0539")
  (valid? "1")

  )
