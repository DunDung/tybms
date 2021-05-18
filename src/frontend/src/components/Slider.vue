<template>
  <v-carousel cycle hide-delimiter-background interval="3000" height="500">
    <v-carousel-item v-for="(slide, i) in slides" :key="i">
      <v-row class="fill-height" align="center" justify="center">
        <img
                height="100%"
          src="@/assets/images/main/main-slider/1.png"
        />
      </v-row>
    </v-carousel-item>
  </v-carousel>
</template>
<script>
export default {
  data() {
    return {
      slides: [require("@/assets/images/main/main-slider/1(640).png")]
    };
  }
};
</script>
<style scoped>
  img {
  }
</style>
