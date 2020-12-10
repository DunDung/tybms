<template>
  <v-container class="welcome-wrap">
    <span class="phrase-title">{{ phrase.title }}</span>
    <span class="phrase-sub-title">{{ phrase.subTitle }}</span>
  </v-container>
</template>
<script>
export default {
  props: ["phrase"]
};
</script>
<style scoped>
.welcome-wrap {
  margin-top: 1.5%;
  margin-bottom: 3.5%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  font-family: "Noto Sans KR", sans-serif;
}
.phrase-title {
  font-size: 3.5vw;
  letter-spacing: 0.2vw;
}
.phrase-sub-title {
  font-size: 1.3vw;
  color: gray;
}
</style>
