import Vue from "vue";
import VueRouter from "vue-router";
import Main from "@/views/Main.vue";
import SmartGo from "@/views/product-about/SmartGo.vue";
import NewDealGo from "@/views/product-about/NewDealGo.vue";
import GreenNewDealGo from "@/views/product-about/GreenNewDealGo.vue";
import ProductSpecification from "@/views/product-about/ProductSpecification.vue";
import Notice from "@/views/customer-support/Notice.vue";
import Archives from "@/views/customer-support/Archives.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Main",
    component: Main
  },
  {
    path: "/smart-go",
    name: "SmartGo",
    component: SmartGo
  },
  {
    path: "/new-deal-go",
    name: "NewDealGo",
    component: NewDealGo
  },
  {
    path: "/green-new-deal-go",
    name: "GreenNewDealGo",
    component: GreenNewDealGo
  },
  {
    path: "/product-specification",
    name: "ProductSpecification",
    component: ProductSpecification
  },
  {
    path: "/archives",
    name: "Archives",
    component: Archives
  },
  {
    path: "/notice",
    name: "Notice",
    component: Notice
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
