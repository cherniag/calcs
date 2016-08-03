(ns calcs.core
  (:require [calcs.parser :as parser])
  (:gen-class
   :implements [java.io.Serializable]
   :name com.gc.calcs.Parser
   :methods [[parse [String] java.util.List]
             [calc  [clojure.lang.PersistentVector java.util.Map] Number]])
  (:import (java.util List Map)))

(defn -parse
  "Takes input string and returns a parsed tree."
  [_ ^String text]
  (parser/parse text))

(defn -calc
  "Takes input string and returns a parsed tree."
  [_ ^clojure.lang.PersistentVector expr mapping]
  (parser/calc expr mapping))
