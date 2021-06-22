import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    notices: [
      {
        id: 0,
        title: "",
        content: "",
        viewCount: 0,
        fileNames: []
      }
    ],
    materials: [
      {
        id: 0,
        title: "",
        content: "",
        viewCount: 0,
        fileNames: []
      }
    ],
    products: [
      {
        id: 0,
        title: "",
        viewCount: 0,
        fileNames: []
      }
    ]
  },
  getters: {
    getNotices(state) {
      return state.notices;
    },
    getMainCardNotices(state) {
      return state.notices.slice(0, 8);
    },
    getMaterials(state) {
      return state.materials;
    },
    getMainCardMaterials(state) {
      return state.materials.slice(0, 8);
    },
    getProducts(state) {
      return state.products;
    }
  },
  mutations: {
    SET_NOTICES(state, notices) {
      console.log(notices);
      state.notices = notices.sort((a, b) => (a.id - b.id) * -1);
    },
    SET_MATERIALS(state, materials) {
      console.log(materials);
      state.materials = materials.sort((a, b) => (a.id - b.id) * -1);
    },
    SET_PRODUCTS(state, products) {
      console.log(products);
      state.products = products.sort((a, b) => (a.id - b.id) * -1);
    }
  },
  actions: {
    requestResource({ dispatch }) {
      dispatch("requestGet", { uri: "/notices", mutationName: "SET_NOTICES" });
      dispatch("requestGet", { uri: "/materials", mutationName: "SET_MATERIALS" });
      dispatch("requestGet", { uri: "/products", mutationName: "SET_PRODUCTS" });
    },
    requestGet({ commit }, request) {
      axios
        .get(request.uri)
        .then(response => commit(request.mutationName, response.data))
        .catch(error => alert(error.response.data));
    }
  },
  modules: {}
});
