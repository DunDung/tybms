<template>
  <v-main>
    <img width="100%" src="@/assets/images/header/top-header2.jpg" />
    <v-container class="container">
      <a href="/">
        <img id="logo" src="@/assets/images/header/logo.png" />
      </a>
      <v-tabs class="menus" fixed-tabs light optional>
        <v-tab class="menu-element" to="/about">
          회사소개
        </v-tab>
        <v-tab class="menu-element" to="/#2">
          사업분야
        </v-tab>
        <v-tab class="menu-element" to="/#3">
          쇼핑하기
        </v-tab>
        <v-tab class="menu-element" to="/#4">
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
<script></script>
<style scoped>
.container {
  diplay: flex;
  text-align: center;
}
#logo {
}
.menus {
  margin: 0 auto;
  max-width: 80%;
}
.menu-element {
  color: black !important;
}
</style>
