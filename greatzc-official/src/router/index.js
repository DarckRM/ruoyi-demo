import { createWebHistory, createRouter } from "vue-router";

import Index from "../views/Index.vue";
import Products from "../views/Products.vue";
import About from "../views/About.vue";
import Contact from "../views/Contact.vue";
import News from "../views/News.vue";

const routes = [
  { path: "/", redirect: "/index" },
  { path: "/index.html", redirect: "/index" },
  { path: "/news", redirect: "/news/all" },
  { path: "/index", component: Index },
  {
    path: "/products",
    component: Products,
  },
  { path: "/contact", component: Contact },
  { path: "/about", component: About },
  {
    path: "/product/:name/:id",
    component: () => import("../views/ProductDetail.vue"),
  },
  {
    path: "/news",
    component: News,
    children: [
      {
        path: "all",
        name: "all",
        component: () => import("../components/news/Main.vue"),
      },
      {
        path: "type/:type",
        name: "type",
        component: () => import("../components/news/Main.vue"),
      },
      {
        path: ":title/:id",
        component: () => import("../views/NewsDetail.vue"),
      },
    ],
  },
];

export const router = createRouter({
  history: createWebHistory(),
  routes: routes,
});

router.beforeEach((to, from, next) => {
  document.documentElement.scrollTop = 0;
  next();
});

export default router;
