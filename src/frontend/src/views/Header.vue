<template>
  <v-main class="main">
    <img width="100%" src="@/assets/images/header/top-header2.jpg" />
    <v-container class="container">
      <v-row>
        <v-spacer />
        <v-spacer />
        <v-spacer />
        <v-spacer />
        <v-col cols="4">
          <a href="/">
            <img id="logo" src="@/assets/images/header/logo.png" />
          </a>
        </v-col>
        <v-col cols="4">
          <v-btn
            small
            text
            href="https://www.youtube.com/channel/UCMvY1lFX49hn_zjZFUnFgpw"
            target="_blank"
          >
            <v-icon color="red" text>{{ mdiYoutube }}</v-icon>
          </v-btn>
          <v-btn small text>
            <v-icon color="black">{{ accountIcon }}</v-icon>
          </v-btn>
          <v-btn
            small
            text
            href="https://map.naver.com/v5/search/%EB%8F%99%EC%96%91BMS/place/18424837?c=14125347.8479585,4506939.7781789,15,0,0,0,dh"
            target="_blank"
          >
            <v-icon color="green">{{ mapMakerIcon }}</v-icon>
          </v-btn>
          <v-btn small text>
            <v-icon color="black">{{ searchIcon }}</v-icon>
          </v-btn>
        </v-col>
      </v-row>
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
import { mdiAccount, mdiMapMarker, mdiMagnify, mdiYoutube } from "@mdi/js";

export default {
  data: () => ({
    accountIcon: mdiAccount,
    mapMakerIcon: mdiMapMarker,
    searchIcon: mdiMagnify,
    mdiYoutube: mdiYoutube
  }),
  methods: {
    registerBookMark() {
      if (window.chrome) {
        alert("ctrl + d");
      } else {
        window.external.AddFavorite("https://tybms.co.kr", "동양BMS");
      }
    }
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

#logo {
  margin-top: -1vw;
  margin-bottom: -1vw;
  max-width: 50%;
}

.menus {
  margin: 0 auto;
  max-width: 80%;
}

.menu-element {
  color: black !important;
}
</style>
