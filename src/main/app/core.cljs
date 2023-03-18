(ns app.core
  (:require [uix.core :refer [defui $]]
            [uix.dom]))

(declare header app counter)

(defui header []
  ($ :div.px-6
     ($ :h1.text-2xl.mt-6 "UIX + Tailwind starter")))

(defui counter []
  (let [[state set-state!] (uix.core/use-state 0)]
    ($ :div.mt-6.px-6.flex
       ($ :button.p-2.bg-blue-200 {:on-click #(set-state! dec)} "-")
       ($ :span.p-2.bg-blue-100 state)
       ($ :button.p-2.bg-blue-200 {:on-click #(set-state! inc)} "+"))))

(defui app []
  ($ :<>
     ($ header)
     ($ counter)))

(defonce root
  (uix.dom/create-root (js/document.getElementById "app")))

(defn ^:dev/after-load start
  []
  (uix.dom/render-root ($ app) root))

(defn ^:export main
  []
  (start))
