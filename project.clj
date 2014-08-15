(defproject rest-client "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/data.json "0.2.5"]
                 [clj-http "1.0.0"]]
  :plugins [[lein-git-deps "0.0.2-SNAPSHOT"]]
  :main rest-client.core
  :git-dependencies [
    ["https://github.com/SemanticSugar/hack-day-clj-rest-server.git"]])
