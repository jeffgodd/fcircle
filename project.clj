(defproject fcircle "0.1.0"
  :description "Code Challenge: Funding Circle fun with primes"
  :url "http://example.com/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot fcircle.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
