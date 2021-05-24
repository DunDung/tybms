<template>
  <v-main>
    <ImageFrame :frame="frame" />
    <v-container class="wrap">
      <img src="@/assets/images/KakaoTalk_20210524_155557093.png" />

      <!--      <v-card class="card-wrap" width="70%" elevation="0">-->
<!--        <v-card-title>-->
<!--          <v-icon large class="mdi-icon" color="green">-->
<!--            {{ mdiMapMarker }}-->
<!--          </v-icon>-->
<!--          회사 주소-->
<!--        </v-card-title>-->
<!--        <v-card-text class="card-text">-->
<!--          서울시 구로구 디지털로 285, 701호 (구로동, 에이스트윈타워1차)-->
<!--        </v-card-text>-->
<!--        <v-card-subtitle>-->
<!--          TEL : 02-6347-8330 <br />-->
<!--          FAX : 02-6347-8336-->
<!--        </v-card-subtitle>-->
<!--        <v-card-title>-->
<!--          <v-icon large class="mdi-icon" color="blue">{{-->
<!--            mdiEmailOutline-->
<!--          }}</v-icon>-->
<!--          메일 주소-->
<!--        </v-card-title>-->
<!--        <v-card-text class="card-text">-->
<!--          tybms@chol.com-->
<!--        </v-card-text>-->
<!--        <v-card-text class="card-text">-->
<!--          <v-icon small>{{ mdiCheck }}</v-icon>-->
<!--          전자세금계산서 발행 시 사업자등록증을 보내주세요.-->
<!--        </v-card-text>-->
<!--      </v-card>-->
    </v-container>
  </v-main>
</template>
<script>
import ImageFrame from "@/components/ImageFrame";
import { mdiMapMarker, mdiEmailOutline, mdiCheck } from "@mdi/js";

export default {
  data: () => ({
    frame: {
      content: "찾아오시는 길",
      subContent: `회사소개   >   찾아오시는 길`,
      backgroundImageUrls: {
        w640: require("@/assets/images/frame/company-about/contact-640.png"),
        w960: require("@/assets/images/frame/company-about/contact-960.png"),
        w1280: require("@/assets/images/frame/company-about/contact-1280.png"),
        w1920: require("@/assets/images/frame/company-about/contact-1920.png")
      }
    },
    mdiMapMarker: mdiMapMarker,
    mdiEmailOutline: mdiEmailOutline,
    mdiCheck: mdiCheck
  }),
  components: {
    ImageFrame
  }
};
</script>
<style scoped>
  .wrap {
    margin-top: 30px;
    margin-bottom: 30px;
    width: 100%;
  }
  img {
    max-width: 100%;
    height: auto;
  }
.mdi-icon {
  margin-right: 1vw;
}
.card-text {
  padding-bottom: 0;
  color: black !important;
  font-size: 1.1vw;
}
.card-wrap {
  margin: 0 auto;
  padding-bottom: 1.5vw;
  font-family: "Noto Sans KR", sans-serif;
}
</style>
