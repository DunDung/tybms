<template>
  <v-main>
    <img width="100%" src="@/assets/images/header/top-header2.jpg"/>
    <v-container class="container">
      <v-row>
        <v-col cols="3">
          <v-btn text color="grey">즐겨찾기</v-btn>
          <v-btn text color="grey">바로가기</v-btn>
        </v-col>
        <v-spacer/>
        <v-col cols="4">
          <a href="/">
            <img id="logo" src="@/assets/images/header/logo.png"/>
          </a>
        </v-col>
        <v-spacer/>
        <v-col cols="3">
          <v-btn small text>
            <v-icon color="grey">{{accountIcon}}</v-icon>
          </v-btn>
          <v-btn small text>
            <v-icon color="grey">{{mapMakerIcon}}</v-icon>
          </v-btn>
          <v-btn small text>
            <v-icon color="grey">{{searchIcon}}</v-icon>
          </v-btn>
        </v-col>
      </v-row>
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
<script>
import {mdiAccount,mdiMapMarker,mdiMagnify} from "@mdi/js";

export default {
  data() {
    return {
      accountIcon: mdiAccount,
      mapMakerIcon: mdiMapMarker,
      searchIcon: mdiMagnify
    }
  }
}
</script>
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
