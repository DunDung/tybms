<template>
  <v-main>
    <v-carousel cycle hide-delimiter-background>
      <v-carousel-item v-for="(slide, i) in slides" :key="i">
        <v-row class="fill-height" align="center" justify="center">
          <img :src="slide" />
        </v-row>
      </v-carousel-item>
    </v-carousel>
  </v-main>
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

