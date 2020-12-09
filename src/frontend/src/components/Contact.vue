<template>
  <v-main>
    <Phrase :phrase="phrase" />
    <v-container>
      <v-card class="card-wrap" width="70%" elevation="0">
        <v-card-title>
          <v-icon large class="mdi-icon" color="green">{{ mdiMapMarker }}</v-icon>
          회사 주소
        </v-card-title>
        <v-card-text class="card-text">
          서울시 구로구 디지털로 285, 701호 (구로동, 에이스트윈타워1차)
        </v-card-text>
        <v-card-subtitle>
          TEL : 02-6347-8330 <br />
          FAX : 02-6347-8336
        </v-card-subtitle>
        <v-card-title>
          <v-icon large class="mdi-icon" color="blue">{{ mdiEmailOutline }}</v-icon>
          메일 주소
        </v-card-title>
        <v-card-text class="card-text">
          김현아(hakim@tybms.co.kr)
        </v-card-text>
        <v-card-text class="card-text">
          <v-icon small>{{ mdiCheck }}</v-icon>
          전자세금계산서 발행 시 사업자등록증을 보내주세요.
        </v-card-text>
      </v-card>
    </v-container>
  </v-main>
</template>
<script>
import Phrase from "@/components/Phrase";
import { mdiMapMarker, mdiEmailOutline, mdiCheck } from "@mdi/js";

export default {
  data: () => ({
    phrase: {
      title: "TYBMS CONTACT",
      subTitle: "동양비엠에스를 찾아주셔서 감사합니다!"
    },
    mdiMapMarker: mdiMapMarker,
    mdiEmailOutline: mdiEmailOutline,
    mdiCheck: mdiCheck
  }),
  components: {
    Phrase
  }
};
</script>
<style scoped>
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
