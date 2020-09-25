(ns serverless.core)

(defn hello [_ response]
  (-> (.getWriter response)
      (spit "Hello, Serverless\n")))
