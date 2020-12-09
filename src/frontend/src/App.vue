<template>
  <v-app>
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
 {
  font-family: "Nanum Gothic", sans-serif !important;
  /*font-family: 'Noto Sans KR', sans-serif;*/
  /* font-family: 'Yeon Sung', cursive;*/
  /* font-family: "Do Hyeon", sans-serif;*/
}
</style>
