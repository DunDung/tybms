<template>
  <v-carousel cycle hide-delimiter-background interval="3000" height="500px">
    <v-carousel-item v-for="(slide, i) in slides" :key="i">
      <v-row class="fill-height" align="center" justify="center">
        <img
          height="100%"
          :src="slide" />
<!--          srcset="@/assets/images/slider/text-320.jpg 320w,-->
<!--          @/assets/images/slider/text-640.jpg 640w,-->
<!--          @/assets/images/slider/text-960.jpg 960w,-->
<!--          @/assets/images/slider/text-1280.jpg 1280w,-->
<!--          @/assets/images/slider/text-1920.jpg 1920w"-->
<!--          sizes="100vw" />-->
      </v-row>
    </v-carousel-item>
  </v-carousel>
</template>
<script>
export default {
  data() {
    return {
      slides: [
        require("@/assets/images/slider/slider-img01.png"),
        // require("@/assets/images/slider/slider-img02.png"),
        // require("@/assets/images/slider/slider-img03.png"),
        // require("@/assets/images/slider/slider-img04.png"),
        // require("@/assets/images/slider/slider-img05.png"),
      ]
    };
  }
};
</script>
<style scoped></style>
