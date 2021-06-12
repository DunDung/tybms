import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    notices: [
      {
        id: -1,
        title: "",
        content: "",
        fileNames: []
      }
    ],
    materials: [
      {
        id: -1,
        title: "",
        content: "",
        fileNames: []
      }
    ]
  },
  getters: {
    getNotices(state) {
      return state.notices;
    },
    getMaterials(state) {
      return state.materials;
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
    }
  },
  actions: {
    requestNotices({ dispatch }) {
      dispatch("requestGet", { uri: "/notices", mutationName: "SET_NOTICES" });
      dispatch("requestGet", { uri: "/materials", mutationName: "SET_MATERIALS" });
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
