<template>
  <v-app id="app">
    <Header />
    <router-view />
    <ScrollToTopButton />
  </v-app>
</template>

<script>
import Header from "@/views/Header";
import ScrollToTopButton from "@/views/ScrollToTopButton";

export default {
  name: "App",

  components: {
    Header,
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
