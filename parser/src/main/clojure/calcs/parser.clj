(ns calcs.parser
  (:require [instaparse.core :as insta]
            [clojure.string :as str]
            [clojure.edn :as edn]
            [instaparse.failure :as fail])
)

(defn init-parser
  "Read instaparse grammar file and build parser.
  Supported options the same as insta/parser"
  [path-to-grammar & opts]
  (-> path-to-grammar
      clojure.java.io/resource
      (#(apply insta/parser % opts))))

(def parser (init-parser "grammar.bnf"))

; pretty-print a failure as a string
(defn failure->string [result]
  (with-out-str (fail/pprint-failure result)))

; create an Exception with the pretty-printed failure message
(defn failure->exn [result]
  (RuntimeException. (failure->string result)))


(defn parse
    [text & opts]
    (let [res (apply insta/parse parser text opts)]
        (if (instance? instaparse.gll.Failure res)
              (throw (failure->exn res))
              res
        )
    )
)

(defn calc
      [expr mapping]
      (insta/transform
         {
         :ADD +,
         :SUB -,
         :MUL *,
         :DIV /,
         :OPERAND identity,
         :CONSTANT edn/read-string,
         :VAR (get mapping identity),
         :EXPR identity} expr)
)




