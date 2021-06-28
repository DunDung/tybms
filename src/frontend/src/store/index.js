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
        attachedFiles: []
      }
    ],
    materials: [
      {
        id: 0,
        title: "",
        content: "",
        modifiedDate: "",
        viewCount: 0,
        attachedFiles: []
      }
    ],
    products: [
      {
        id: 0,
        title: "",
        modifiedDate: "",
        viewCount: 0,
        attachedFile: {}
      }
    ],
    noticeViewCountRepository: new Map(),
    materialViewCountRepository: new Map(),
    productViewCountRepository: new Map()
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
    },
    SET_NOTICE_VIEW_COUNTS(state, payload) {
      state.notices[payload.index].viewCount++;
      if (state.noticeViewCountRepository.has(payload.id)) {
        state.noticeViewCountRepository.set(
          payload.id,
          state.noticeViewCountRepository.get(payload.id) + 1
        );
      } else {
        state.noticeViewCountRepository.set(payload.id, 1);
      }
    },
    SET_MATERIAL_VIEW_COUNTS(state, payload) {
      state.materials[payload.index].viewCount++;
      if (state.materialViewCountRepository.has(payload.id)) {
        state.materialViewCountRepository.set(
          payload.id,
          state.materialViewCountRepository.get(payload.id) + 1
        );
      } else {
        state.materialViewCountRepository.set(payload.id, 1);
      }
    },

    SET_PRODUCT_VIEW_COUNTS(state, payload) {
      state.products[payload.index].viewCount++;
      if (state.productViewCountRepository.has(payload.id)) {
        state.productViewCountRepository.set(
          payload.id,
          state.productViewCountRepository.get(payload.id) + 1
        );
      } else {
        state.productViewCountRepository.set(payload.id, 1);
      }
    }
  },
  actions: {
    requestFindAllResources({ dispatch }) {
      dispatch("requestGetFindAll", {
        uri: "/notices",
        mutationName: "SET_NOTICES"
      });
      dispatch("requestGetFindAll", {
        uri: "/materials",
        mutationName: "SET_MATERIALS"
      });
      dispatch("requestGetFindAll", {
        uri: "/products",
        mutationName: "SET_PRODUCTS"
      });
    },
    requestGetFindAll({ commit }, request) {
      axios
        .get(request.uri)
        .then(response => {
          let resources = response.data;
          resources
            .sort((a, b) => (a.id - b.id) * -1)
            .forEach(resource => {
              if (request.uri != "/products") {
                resource.attachedFiles = [];
                for (const fileName of resource.fileNames) {
                  resource.attachedFiles.push({
                    fileName: fileName,
                    fileUrl: require(`@/assets/upload-files/${fileName}`)
                  });
                }
              } else {
                resource.attachedFile = {
                  fileName: resource.attachedFile,
                  fileUrl: require(`@/assets/upload-files/${resource.attachedFile}`)
                };
              }
            });
          return resources;
        })
        .then(resources => {
          commit(request.mutationName, resources);
        })
        .catch(error => {
          alert(error.response.data);
        });
    },
    requestIncreaseViewCountResources({ state }) {
      axios
        .patch("/notices", Object.fromEntries(state.noticeViewCountRepository))
        .then(response => console.log(response))
        .catch(error => {
          console.log(error);
          alert(error.response.data);
        });
      axios
        .patch(
          "/materials",
          Object.fromEntries(state.materialViewCountRepository)
        )
        .then(response => console.log(response))
        .catch(error => {
          console.log(error);
          alert(error.response.data);
        });
      axios
        .patch(
          "/products",
          Object.fromEntries(state.productViewCountRepository)
        )
        .then(response => console.log(response))
        .catch(error => {
          console.log(error);
          alert(error.response.data);
        });
    }
  },
  modules: {}
});
