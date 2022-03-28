(ns datahike-ddb-s3.core
  (:require [datahike.store :refer [empty-store delete-store connect-store scheme->index default-config]]
            [konserve-ddb-s3.core :as ds]
            [superv.async :refer [<?? S]]))

(defmethod empty-store :ddb-s3 [config]
  (<?? S (ds/empty-store config)))

(defmethod delete-store :ddb-s3 [config]
  (ds/delete-store config))

(defmethod connect-store :ddb-s3 [config]
  (<?? S (ds/connect-store config)))

(defmethod scheme->index :ddb-s3 [_]
  :datahike.index/hitchhiker-tree)

(defmethod default-config :ddb-s3 [config]
  (merge
   {:region "us-east-1"
    :database "main_database"}
   config))