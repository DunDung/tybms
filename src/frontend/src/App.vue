<template>
  <v-app id="app">
    <Header v-if="isNotAdmin"/>
    <router-view></router-view>
    <ScrollToTopButton v-if="isNotAdmin"/>
    <Footer v-if="isNotAdmin"/>
  </v-app>
</template>

<script>
import Header from "@/components/app/Header";
import Footer from "@/components/app/Footer";
import ScrollToTopButton from "@/components/app/ScrollToTopButton";
import EventBus from "@/event-bus/EventBus.js";
import {mapActions} from "vuex";

export default {
  name: "App",

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
    }
  },
  created() {
    this.requestFindAllResources();

    //페이지 나가기 or 새로고침 시 조회수 변경요청 날리도록 등록
    window.addEventListener(
        "beforeunload",
        this.requestIncreaseViewCountResources
    );
  },
  methods: {
    ...mapActions([
      "requestFindAllResources",
      "requestIncreaseViewCountResources"
    ])
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
  height: 100%;
  margin: 0 auto;
  /*font-family: 'Noto Sans KR', sans-serif;*/
  /* font-family: 'Yeon Sung', cursive;*/
  /* font-family: "Do Hyeon", sans-serif;*/
  /*font-family: 'NanumSquare', sans-serif !important;*/
}

@media screen and (max-width: 960px) {
  #app {
    width: 100%;
    /*모바일 오른쪽 여백 제거*/
    overflow-x: hidden;
  }
}
</style>
