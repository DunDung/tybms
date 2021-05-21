import Vue from "vue";
import VueRouter from "vue-router";
import Main from "@/views/Main.vue";
import ProductAbout from "@/views/ProductAbout.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Main",
    component: Main
  },

  {
    path: "/product-about",
    name: "ProductAbout",
    component: ProductAbout
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
