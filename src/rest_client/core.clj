(ns rest-client.core
  (:require [rest-server.const :as const]
            [clj-http.client :as http]))

(defn get-orders
  "Get a list of all orders."
  ([]
    (get-orders (str const/base-url "/orders")))
  ([url]
    ((http/get url) :body)))

(defn -main [& args])
