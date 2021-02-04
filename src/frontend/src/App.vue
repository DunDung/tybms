<template>
  <v-app id="app">
    <!-- Sizes your content based upon application components -->
    <v-main>
      <!-- Provides the application the proper gutter -->
      <Header />
      <!-- If using vue-router -->
      <router-view></router-view>
      <ScrollToTopButton />
        <Footer/>
    </v-main>
  </v-app>
</template>

<script>
import Header from "@/components/Header";
import Footer from "@/components/Footer";
import ScrollToTopButton from "@/components/ScrollToTopButton";

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
  /*font-family: 'Noto Sans KR', sans-serif;*/
  /* font-family: 'Yeon Sung', cursive;*/
  /* font-family: "Do Hyeon", sans-serif;*/
}
</style>
