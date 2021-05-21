<template>
  <v-carousel cycle hide-delimiter-background interval="3000">
    <v-carousel-item v-for="(slide, i) in slides" :key="i">
      <v-row class="fill-height" align="center" justify="center">
        <img
          srcset="
            @/assets/images/main/main-slider/320.png   400w,
            @/assets/images/main/main-slider/640.png   640w,
            @/assets/images/main/main-slider/960.png 960w,
            @/assets/images/main/main-slider/1280.png 1280w,
            @/assets/images/main/main-slider/1920.png 1920w"
          sizes="100vw" />
        <!--        @/assets/images/main/main-slider/1(640).png 640w,-->
<!--        (max-width: 480px) 480px-->
      </v-row>
    </v-carousel-item>
  </v-carousel>
</template>
<script>
export default {
  data() {
    return {
      slides: [require("@/assets/images/main/main-slider/1(960).png")]
    };
  }
};
</script>
<style scoped>
  img {
    height: 100%;
    width: auto;
  }
</style>
