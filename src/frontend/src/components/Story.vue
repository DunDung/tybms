<template>
  <v-main class="main">
    <Phrase :phrase="phrase" />
  </v-main>
</template>
<script>
import Phrase from "@/components/Phrase";
export default {
  data() {
    return {
      phrase: {
        title: "TYBMS STORY",
        subTitle: "동양비엠에스에 오신 것을 환영합니다!"
      }
    };
  },
  components: {
    Phrase
  }
};
</script>
<style scoped>
.main {
}
</style>
