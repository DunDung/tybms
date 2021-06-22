<template>
  <v-app id="app">
    <v-main>
      <Header v-if="isNotAdmin" />
      <router-view></router-view>
      <ScrollToTopButton v-if="isNotAdmin" />
      <Footer v-if="isNotAdmin" />
    </v-main>
  </v-app>
</template>

<script>
import Header from "@/components/app/Header";
import Footer from "@/components/app/Footer";
import ScrollToTopButton from "@/components/app/ScrollToTopButton";
import EventBus from "@/event-bus/EventBus.js";
import { mapActions } from "vuex";

export default {
  name: "App",

  created() {
    this.requestResource();
  },
  components: {
    Header,
    Footer,
    ScrollToTopButton
  },
  computed: {
    isNotAdmin() {
      EventBus.$on("admin", isAdminPage => {
        this.isAdmin = isAdminPage;
      });
      return !this.isAdmin;
    },
  },
  methods: {
    ...mapActions(["requestResource"])
  },
  data: () => ({
    isAdmin: false
  })
};
</script>
<style>
#app {
  font-family: "Nanum Gothic", sans-serif;
  width: 80%;
  margin: 0 auto;
  /*font-family: 'Noto Sans KR', sans-serif;*/
  /* font-family: 'Yeon Sung', cursive;*/
  /* font-family: "Do Hyeon", sans-serif;*/
  /*font-family: 'NanumSquare', sans-serif !important;*/
}

/*Board 컴포넌트 스타일 적용이 scoped면 안됨.*/
th {
  font-size: 1vw !important;
  font-weight: bold;
  background-color: #f0f0f0;
}

td {
  font-size: 0.9vw !important;
  cursor: pointer;
}
/**/

@media screen and (max-width: 960px) {
  #app {
    width: 100%;
  }
}
</style>
