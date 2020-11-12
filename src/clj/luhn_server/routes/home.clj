(ns luhn-server.routes.home
  (:require
   [luhn-server.layout :as layout]
   [luhn-server.luhn :as l]
   [clojure.java.io :as io]
   [luhn-server.middleware :as middleware]
   [ring.util.response]
   [ring.util.http-response :as response]))

(defn home-page [request]
  (layout/render request "home.html"))

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get home-page}]
   ["/luhn" {:get (fn [{{:keys [value]}:params}]
                    (-> (response/ok (str (l/valid? value)))
                        (response/header "Content-Type" "application/json; charset=utf-8")))}]])

