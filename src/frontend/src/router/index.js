import Vue from "vue";
import VueRouter from "vue-router";
import Main from "@/views/Main";
import SmartGo from "@/views/product-about/SmartGo";
import NewDealGo from "@/views/product-about/NewDealGo";
import GreenNewDealGo from "@/views/product-about/GreenNewDealGo";
import ProductSpecification from "@/views/product-about/ProductSpecification";
import Notice from "@/views/customer-support/Notice";
import Archives from "@/views/customer-support/Archives";
import Greeting from "@/views/company-about/Greeting";
import History from "@/views/company-about/History";
import Performance from "@/views/company-about/Performance";
import Contact from "@/views/company-about/Contact";

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
  {
    path: "/greeting",
    name: "Greeting",
    component: Greeting
  },
  {
    path: "/history",
    name: "History",
    component: History
  },
  {
    path: "/performance",
    name: "Performance",
    component: Performance
  },
  {
    path: "/contact",
    name: "Contact",
    component: Contact
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
