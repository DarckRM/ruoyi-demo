import { createWebHistory, createRouter } from "vue-router";

import Index from "../views/Index.vue";
import Products from "../views/Products.vue";
import About from "../views/About.vue";
import Contact from "../views/Contact.vue";

const routes = [
  { path: "/", redirect: "/index" },
  { path: "/index.html", redirect: "/index" },
  { path: "/index", component: Index },
  {
    path: "/products",
    component: Products,
  },
  { path: "/contact", component: Contact },
  { path: "/about", component: About },
  {
    path: "/product/:category/:name/:id",
    component: () => import("../views/ProductDetail.vue"),
  },
];

export const router = createRouter({
  history: createWebHistory(),
  routes: routes,
});

export default router;
