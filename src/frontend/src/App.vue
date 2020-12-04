<template>
  <v-app>
    <Header />
    <router-view />
  </v-app>
</template>

<script>
import Header from "@/views/Header";

export default {
  name: "App",

  components: {
    Header
  },

  data: () => ({
    //
  })
};
</script>
<style>
* {
  font-family: "Nanum Gothic", sans-serif;
  /*font-family: 'Noto Sans KR', sans-serif;*/
}

.border {
  border: red 3px solid;
}
</style>
