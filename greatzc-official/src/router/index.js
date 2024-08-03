import { createWebHistory, createRouter } from "vue-router";

import Index from "../views/Index.vue";
import About from "../views/About.vue";

const routes = [
  { path: "/", redirect: "/index"},
  { path: "/index", component: Index},
  { path: "/about", component: About},
];

export const router = createRouter({
  history: createWebHistory(),
  routes: routes,
});

export default router