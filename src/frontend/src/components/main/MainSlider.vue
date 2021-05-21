<template>
  <v-carousel cycle hide-delimiter-background interval="3000">
    <v-carousel-item v-for="(slide, i) in slides" :key="i">
      <v-row class="fill-height" align="center" justify="center">
        <picture>
          <source :srcset="`${slide.w320}`" media="(min-width: 200px)" />
          <source :srcset="`${slide.w640}`" media="(min-width: 630px)" />
          <source :srcset="`${slide.w960}`" media="(min-width: 950px)" />
          <source :srcset="`${slide.w1280}`" media="(min-width: 1270px)" />
          <source :srcset="`${slide.w1920}`" media="(min-width: 1910px)" />
          <img :src="`${slide.w1920}`" alt="" />
        </picture>
        <!--          <img-->
        <!--          :srcset="-->
        <!--            `-->
        <!--            ${slide.w320} 380w,-->
        <!--            ${slide.w640} 640w,-->
        <!--            ${slide.w960} 960w,-->
        <!--            ${slide.w1280} 1280w,-->
        <!--            ${slide.w1920} 1920w,-->
        <!--          `-->
        <!--          "-->
        <!--          sizes="(max-width: 400px) 380px,"-->
        <!--        />-->
      </v-row>
    </v-carousel-item>
  </v-carousel>
</template>
<script>
export default {
  data() {
    return {
      slides: [
        {
          w320: require("@/assets/images/main/main-slider/320.png"),
          w640: require("@/assets/images/main/main-slider/640.png"),
          w960: require("@/assets/images/main/main-slider/960.png"),
          w1280: require("@/assets/images/main/main-slider/1280.png"),
          w1920: require("@/assets/images/main/main-slider/1920.png")
        },
        {
          w320: require("@/assets/images/main/main-slider/320.png"),
          w640: require("@/assets/images/main/main-slider/640.png"),
          w960: require("@/assets/images/main/main-slider/960.png"),
          w1280: require("@/assets/images/main/main-slider/1280.png"),
          w1920: require("@/assets/images/main/main-slider/1920.png")
        },
        {
          w320: require("@/assets/images/main/main-slider/320.png"),
          w640: require("@/assets/images/main/main-slider/640.png"),
          w960: require("@/assets/images/main/main-slider/960.png"),
          w1280: require("@/assets/images/main/main-slider/1280.png"),
          w1920: require("@/assets/images/main/main-slider/1920.png")
        },
        {
          w320: require("@/assets/images/main/main-slider/320.png"),
          w640: require("@/assets/images/main/main-slider/640.png"),
          w960: require("@/assets/images/main/main-slider/960.png"),
          w1280: require("@/assets/images/main/main-slider/1280.png"),
          w1920: require("@/assets/images/main/main-slider/1920.png")
        }
      ]
    };
  }
};
</script>
<style scoped>
img {
  height: 100%;
  width: 100%;
}
</style>
