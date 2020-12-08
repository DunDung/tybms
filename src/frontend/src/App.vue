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
  font-family: "Nanum Gothic", sans-serif;
  /*font-family: 'Noto Sans KR', sans-serif;*/
}
</style>
