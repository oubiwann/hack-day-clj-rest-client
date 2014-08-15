(ns rest-client.core
  (:require [rest-server.const :as const]
            [clj-http.client :as http]))

(defn get-orders
  "Get a list of all orders."
  ([]
    (get-orders const/base-url))
  ([base-url]
    ((http/get (str base-url "/orders")) :body)))

(defn -main [& args])
