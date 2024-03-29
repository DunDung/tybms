import Vue from "vue";
import VueRouter from "vue-router";
import Main from "@/views/Main";
import SmartGo from "@/views/product-about/SmartGo";
import NewDealGo from "@/views/product-about/NewDealGo";
import GreenNewDealGo from "@/views/product-about/GreenNewDealGo";
import ProductCatalog from "@/views/product-about/ProductCatalog";
import Notice from "@/views/customer-support/Notice";
import Archive from "@/views/customer-support/Archive";
import Greeting from "@/views/company-about/Greeting";
import History from "@/views/company-about/History";
import Performance from "@/views/company-about/Performance";
import Contact from "@/views/company-about/Contact";
import Admin from "@/views/admin/Admin";
import Error from "@/views/Error";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Main",
    component: Main
  },
  {
    path: "*",
    redirect: "/404"
  },
  {
    path: "/404",
    name: "Error",
    component: Error
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
    path: "/product-catalog",
    name: "ProductCatalog",
    component: ProductCatalog
  },
  {
    path: "/archive",
    name: "Archive",
    component: Archive,
    children: [
      {
        path: "/archive/:id",
        component: Archive
      }
    ]
  },
  {
    path: "/notice",
    name: "Notice",
    component: Notice,
    children: [
      {
        path: "/notice/:id",
        component: Notice
      }
    ]
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
  },
  {
    path: "/admin",
    name: "Admin",
    component: Admin
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
