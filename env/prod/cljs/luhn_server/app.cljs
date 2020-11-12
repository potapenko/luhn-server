(ns luhn-server.app
  (:require [luhn-server.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
