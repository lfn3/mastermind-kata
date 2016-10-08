(defproject mastermind-kata "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  :dependencies [[org.clojure/clojure "1.9.0-alpha13"]]
  :plugins [[lein-virgil "0.1.0"]]
  :profiles {:dev {:dependencies [[org.clojure/test.check "0.9.0"]]}})
