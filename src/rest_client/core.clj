(ns rest-client.core
  (:require [rest-server.const :as const]
            [clj-http.client :as http]))

(defn get-orders
  "Get a list of all orders."
  ([]
    (get-orders const/base-url))
  ([base-url]
    ((http/get (str base-url "/orders")) :body)))

(defn get-order
  "Get a single order by ID"
  ([id]
   (get-order const/base-url id))
  ([base-url id]
   ((http/get (str base-url "/order/" id)) :body)))

(defn -main [& args])
