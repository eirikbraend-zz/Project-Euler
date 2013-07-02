(ns euler.learning)

(def runtime (Runtime/getRuntime))
(pprint (.availableProcessors runtime))


(import '(java.util.concurrent Executors))
 
(defn test-stm [nitems nthreads niters]
  (let [refs  (map ref (repeat nitems 0))
        pool  (Executors/newFixedThreadPool nthreads)
        tasks (map (fn [t]
                     (fn []
                       (dotimes [n niters]
                         (dosync
                          (doseq [r refs]
                            (alter r + 1 t))))))
                   (range nthreads))]
    (doseq [future (.invokeAll pool tasks)]
      (.get future))
    (.shutdown pool)
    (map deref refs)))

;;(test-stm 10 10 10000)

(dotimes [n 3] (pprint {:foo n, :navn ["eirik" "brand"]}))

(defn dyr-func []
  (do (Thread/sleep 2000)
      (.getName (Thread/currentThread))))


(def my-ref (ref 10))
