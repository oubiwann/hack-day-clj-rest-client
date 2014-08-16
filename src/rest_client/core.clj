(ns rest-client.core
  (:require [clojure.string :as string]
            [rest-server.const :as const]
            [clj-http.client :as http]))

(defn -second [args]
  (into [] (drop 1 args)))

(defn -make-fn-name [method thing]
  (symbol (str (name method) "-" (name thing))))

(defn -make-http-call [method]
  (symbol (str "http/" (name method))))

(defn -split-thing [thing]
  (string/replace (name thing) #"-" "/"))

(defn -make-http-arg [args thing]
  `(str ~(first args) (str ~(str "/" (-split-thing thing) "/")
                           ~(first (-second args)))))

(defmacro make-client-fn [docstring method thing args]
  `(defn ~(-make-fn-name method thing)
     (~(-second args)
      (~(-make-fn-name method thing) const/base-url))
     (~args
      ((~(-make-http-call method)
          ~(-make-http-arg args thing)) :body))))

(make-client-fn
  "Get a list of all orders."
  :get :orders [base-url])

(make-client-fn
  "Get a single order by ID."
  :get :order [base-url id])

(make-client-fn
  "Get payment status by ID."
  :get :payment-order [base-url id])

(make-client-fn
  "Make payment by ID."
  :put :payment-order [base-url id])

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

(defn get-payment-order
  "Get payment status by ID."
  ([id]
   (get-payment-order const/base-url id))
  ([url id]
   ((http/get (str url "/payment/order/" id)) :body)))

(defn put-payment-order
  "Make payment by ID"
  ([id]
   (put-payment-order const/base-url id))
  ([url id]
   ((http/put (str url "/payment/order/" id)) :body)))

(defn -main [& args])
