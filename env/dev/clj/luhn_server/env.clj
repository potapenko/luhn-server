(ns luhn-server.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [luhn-server.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[luhn-server started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[luhn-server has shut down successfully]=-"))
   :middleware wrap-dev})
