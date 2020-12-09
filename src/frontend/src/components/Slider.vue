<template>
    <v-carousel class="carousel" cycle hide-delimiter-background>
    <v-carousel-item v-for="(slide, i) in slides" :key="i">
      <v-row class="fill-height" align="center" justify="center">
          <img :src="slide" height="100%"/>
      </v-row>
    </v-carousel-item>
  </v-carousel>
</template>
<script>
export default {
  data() {
    return {
      slides: [
        require("@/assets/images/slider/slider-img01.jpg"),
        require("@/assets/images/slider/slider-img02.jpg"),
        require("@/assets/images/slider/slider-img03.jpg")
      ]
    };
  }
};
</script>
<style scoped></style>
