(ns mastermind-kata.core
  (:require [clojure.spec :as s]
            [clojure.spec.gen :as gen])
  (:import (mastermind_kata Game Score)))


(s/def ::secret (s/with-gen (s/and string?
                                   #(= (count %1) 6))
                            #(gen/fmap (fn [x]
                                         (apply str x))
                                       (->> [\r \y \b \w \c \g]
                                            (map gen/return)
                                            (gen/one-of)
                                            (repeat 6)
                                            (apply gen/tuple)))))
(s/def ::guess ::secret)

(defn start-and-guess [secret guess]
  (-> (Game. secret)
      (.guess guess)))

(s/fdef start-and-guess
  :args (s/cat :secret ::secret
               :guess ::guess)
  :ret #(instance? Score %1)
  :fn #(let [matches (+ (.-inexactMatches (:ret %1))
                        (.-exactMatches (:ret %1)))]
        (and (>= matches
                 0)
             (<= matches
                 6))))
