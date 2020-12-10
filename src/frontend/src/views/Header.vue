<template>
  <v-main class="main">
    <img width="100%" src="@/assets/images/header/top-header2.jpg" />
    <v-container class="container">
      <TopMenu />
      <v-tabs class="menus" fixed-tabs light optional show-arrows>
        <v-tab class="menu-element" to="/about">
          회사소개
        </v-tab>
        <v-tab class="menu-element" to="/business">
          사업분야
        </v-tab>
        <v-tab class="menu-element" to="/#3">
          쇼핑하기
        </v-tab>
        <v-tab class="menu-element" to="/licence">
          인증 및 특허현황
        </v-tab>
        <v-tab class="menu-element" to="/#5">
          고객센터
        </v-tab>
        <v-tab class="menu-element" to="/#6">
          자료실
        </v-tab>
      </v-tabs>
    </v-container>
  </v-main>
</template>
<script>
import TopMenu from "@/components/TopMenu";
export default {
  data: () => ({}),
  components: {
    TopMenu
  }
};
</script>
<style scoped>
.main {
  overflow: auto;
  font-family: "Nanum Gothic", sans-serif;
}
.container {
  diplay: flex;
  text-align: center;
}

.menus {
  margin: 0 auto;
  max-width: 80%;
}

.menu-element {
  color: black !important;
}
</style>
