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
        modifiedDate: "",
        viewCount: 0,
        fileNames: []
      }
    ],
    materials: [
      {
        id: 0,
        title: "",
        content: "",
        modifiedDate: "",
        viewCount: 0,
        fileNames: []
      }
    ],
    products: [
      {
        id: 0,
        title: "",
        modifiedDate: "",
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
      state.notices = notices;
    },
    SET_MATERIALS(state, materials) {
      console.log(materials);
      state.materials = materials;
    },
    SET_PRODUCTS(state, products) {
      console.log(products);
      state.products = products;
    }
  },
  actions: {
    addAttachedFiles(resource) {
      resource.attachedFiles = [];
      for (const fileName of resource.fileNames) {
        resource.attachedFiles.push({
          fileName: fileName,
          fileUrl: require(`@/assets/upload-files/${fileName}`)
        });
      }
    },
    requestResource({ dispatch }) {
      dispatch("requestGet", {
        uri: "/notices",
        mutationName: "SET_NOTICES"
      });
      dispatch("requestGet", {
        uri: "/materials",
        mutationName: "SET_MATERIALS"
      });
      dispatch("requestGet", {
        uri: "/products",
        mutationName: "SET_PRODUCTS"
      });
    },
    requestGet({ commit }, request) {
      axios
        .get(request.uri)
        .then(response => {
          let resources = response.data;
          resources
            .sort((a, b) => (a.id - b.id) * -1)
            .forEach(resource => {
              resource.attachedFiles = [];
              for (const fileName of resource.fileNames) {
                resource.attachedFiles.push({
                  fileName: fileName,
                  fileUrl: require(`@/assets/upload-files/${fileName}`)
                });
              }
            });
          return resources;
        })
        .then(resources => commit(request.mutationName, resources))
        .catch(error => alert(error.response.data));
    }
  },
  modules: {}
});
