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

(defn get-payment
  "Get payment status by ID"
  ([id]
   (get-payment const/base-url id))
  ([url id]
   ((http/get (str url "/payment/order/" id)) :body)))

(defn put-payment
  "Make payment by ID"
  ([id]
   (put-payment const/base-url id))
  ([url id]
   ((http/put (str url "/payment/order/" id)) :body)))

(defn -main [& args])
