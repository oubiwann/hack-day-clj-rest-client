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

(defn create-order
  "Create a new order. TODO: json-ify the order"
  ([order]
    (create-order const/base-url order-content))
  ([base-url order]
   ((http/post (str base-url "/order")
               {:body (str order)
                :content-type :json}))))

(defn delete-order
  "Delete a completed order."
  ([order-id]
   (delete-order const/base-url order-id))
  ([base-url order-id]
   ((http/delete (str base-url "/order/" order-id)))))

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
