<template>
  <v-app id="app">
    <!-- Sizes your content based upon application components -->
    <v-main>
      <!-- Provides the application the proper gutter -->
      <Header />
      <!-- If using vue-router -->
      <router-view></router-view>
      <ScrollToTopButton />
      <Footer />
    </v-main>
  </v-app>
</template>

<script>
import Header from "@/components/app/Header";
import Footer from "@/components/app/Footer";
import ScrollToTopButton from "@/components/app/ScrollToTopButton";

export default {
  name: "App",

  components: {
    Header,
    Footer,
    ScrollToTopButton
  },

  data: () => ({})
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
@media screen and (max-width: 960px) {
  #app {
    width: 100%;
  }
}
</style>
