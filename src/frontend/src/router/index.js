import Vue from "vue";
import VueRouter from "vue-router";
import Home from "@/views/Home.vue";
import About from "@/views/About.vue";
import Business from "@/views/Business.vue";
import Licence from "@/views/Licence.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },

  {
    path: "/about",
    name: "About",
    component: About
  },
  {
    path: "/business",
    name: "Business",
    component: Business
  },
  {
    path: "/licence",
    name: "Licence",
    component: Licence
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
