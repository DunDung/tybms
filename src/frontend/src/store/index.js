import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    notices: []
  },
  getters: {
    getNotices(state) {
      return state.notices;
    }
  },
  mutations: {
    SET_NOTICES(state, notices) {
      console.log(notices)
      state.notice = notices;
    }
  },
  actions: {
    requestNotices({ commit }) {
      axios.get("/notices").then(response => {
        commit("SET_NOTICES", response.data);
      }).catch(error => alert(error.response.data));
    }
  },
  modules: {}
});
