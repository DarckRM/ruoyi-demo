import { createMemoryHistory, createRouter } from "vue-router";

import Index from "../views/Index.vue";

const routes = [
  { path: "/", redirect: "/index"},
  { path: "/index", component: Index},
];

const router = createRouter({
  history: createMemoryHistory(),
  routes,
});

export default router