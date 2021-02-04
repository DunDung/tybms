<template>
  <v-carousel cycle hide-delimiter-background interval="3000">
    <v-carousel-item v-for="(slide, i) in slides" :key="i">
      <v-row class="fill-height" align="center" justify="center">
        <v-img :src="slide" height="100%" />
      </v-row>
    </v-carousel-item>
  </v-carousel>
</template>
<script>
export default {
  data() {
    return {
      slides: [
        require("@/assets/images/slider/asd01.jpg"),
        require("@/assets/images/slider/slider-img02.jpg"),
        require("@/assets/images/slider/temp01.png"),
      ]
    };
  }
};
</script>
<style scoped></style>
