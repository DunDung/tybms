<template>
  <v-carousel cycle hide-delimiter-background interval="3000">
    <v-carousel-item v-for="(slide, i) in slides" :key="i">
      <v-row class="fill-height" align="center" justify="center">
        <picture>
          <source :srcset="slide.w320" media="(max-width: 400px)" />
          <source :srcset="slide.w640" media="(max-width: 640px)" />
          <source :srcset="slide.w960" media="(max-width: 960px)" />
          <source :srcset="slide.w1280" media="(max-width: 1280px)" />
          <source :srcset="slide.w1920" media="(max-width: 1920px)" />
          <img :src="slide.w1920" />
        </picture>
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
          w320: require("@/assets/images/main/main-slider/1(320).png"),
          w640: require("@/assets/images/main/main-slider/1(640).png"),
          w960: require("@/assets/images/main/main-slider/1(960).png"),
          w1280: require("@/assets/images/main/main-slider/1(1280).png"),
          w1920: require("@/assets/images/main/main-slider/1(1920).png")
        },
        {
          w320: require("@/assets/images/main/main-slider/2(320).png"),
          w640: require("@/assets/images/main/main-slider/2(640).png"),
          w960: require("@/assets/images/main/main-slider/2(960).png"),
          w1280: require("@/assets/images/main/main-slider/2(1280).png"),
          w1920: require("@/assets/images/main/main-slider/2(1920).png")
        },
        {
          w320: require("@/assets/images/main/main-slider/3(320).png"),
          w640: require("@/assets/images/main/main-slider/3(640).png"),
          w960: require("@/assets/images/main/main-slider/3(960).png"),
          w1280: require("@/assets/images/main/main-slider/3(1280).png"),
          w1920: require("@/assets/images/main/main-slider/3(1920).png")
        },
        {
          w320: require("@/assets/images/main/main-slider/4(320).png"),
          w640: require("@/assets/images/main/main-slider/4(640).png"),
          w960: require("@/assets/images/main/main-slider/4(960).png"),
          w1280: require("@/assets/images/main/main-slider/4(1280).png"),
          w1920: require("@/assets/images/main/main-slider/4(1920).png")
        }
      ]
    };
  }
};
</script>
<style scoped>
source {
  height: 100%;
  width: 100%;
}
</style>
