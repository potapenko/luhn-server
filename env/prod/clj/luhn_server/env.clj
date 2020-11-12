(ns luhn-server.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[luhn-server started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[luhn-server has shut down successfully]=-"))
   :middleware identity})
