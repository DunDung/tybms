<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <v-row class="row-wrap">
    <v-spacer />
    <v-col cols="4">
      <a href="/">
        <img id="logo" src="@/assets/images/header/logo.png" />
      </a>
    </v-col>
    <v-col cols="4">
      <v-menu>
        <template v-slot:activator="{ on: menu, attrs }">
          <v-tooltip bottom>
            <template v-slot:activator="{ on: tooltip }">
              <v-btn
                small
                text
                v-bind="attrs"
                v-on="{ ...tooltip, ...menu }"
                href="https://www.youtube.com/channel/UCMvY1lFX49hn_zjZFUnFgpw"
                target="_blank"
              >
                <v-icon color="red" text>{{ mdiYoutube }}</v-icon>
              </v-btn>
            </template>
            <span>YouTube</span>
          </v-tooltip>
        </template>
      </v-menu>
      <v-menu open-on-hover offset-y auto>
        <template v-slot:activator="{ on, attrs }">
          <v-btn small text v-bind="attrs" v-on="on">
            <v-icon color="black">{{ accountIcon }}</v-icon>
          </v-btn>
        </template>
        <v-list>
          <v-list-item>
            <v-list-item-title>로그인</v-list-item-title>
          </v-list-item>
          <v-list-item>
            <v-list-item-title>회원가입</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
      <v-menu>
        <template v-slot:activator="{ on: menu, attrs }">
          <v-tooltip bottom>
            <template v-slot:activator="{ on: tooltip }">
              <v-btn
                small
                text
                v-bind="attrs"
                v-on="{ ...tooltip, ...menu }"
                href="https://map.naver.com/v5/search/%EB%8F%99%EC%96%91BMS/place/18424837?c=14125347.8479585,4506939.7781789,15,0,0,0,dh"
                target="_blank"
              >
                <v-icon color="green" text>{{ mapMakerIcon }}</v-icon>
              </v-btn>
            </template>
            <span>위치</span>
          </v-tooltip>
        </template>
      </v-menu>
      <v-menu>
        <template v-slot:activator="{ on: menu, attrs }">
          <v-tooltip bottom>
            <template v-slot:activator="{ on: tooltip }">
              <v-btn
                small
                text
                v-bind="attrs"
                v-on="{ ...tooltip, ...menu }"
                href="https://map.naver.com/v5/search/%EB%8F%99%EC%96%91BMS/place/18424837?c=14125347.8479585,4506939.7781789,15,0,0,0,dh"
                target="_blank"
              >
                <v-icon color="black" text>{{ searchIcon }}</v-icon>
              </v-btn>
            </template>
            <span>검색하기</span>
          </v-tooltip>
        </template>
      </v-menu>
    </v-col>
  </v-row>
</template>
<script>
import { mdiAccount, mdiMapMarker, mdiMagnify, mdiYoutube } from "@mdi/js";

export default {
  data: () => ({
    accountIcon: mdiAccount,
    mapMakerIcon: mdiMapMarker,
    searchIcon: mdiMagnify,
    mdiYoutube: mdiYoutube
  })
};
</script>
<style scoped>
#logo {
  margin-top: -1vw;
  margin-bottom: -1vw;
  max-width: 50%;
}
.row-wrap {
  font-family: "Nanum Gothic", sans-serif;
}
</style>
