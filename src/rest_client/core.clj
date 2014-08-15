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
  ([order-id]
   (get-order const/base-url order-id))
  ([base-url order-id]
   ((http/get (str base-url "/order/" order-id)) :body)))

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
   ((http/delete (str base-url "/order/" order-id))))

(defn -main [& args])
