<template>
  <v-carousel
    cycle
    height="100%"
    hide-delimiter-background
    show-arrows-on-hover
  >
    <v-carousel-item v-for="(slide, i) in slides" :key="i">
      <v-sheet height="80%">
        <v-row class="fill-height" align="center" justify="center">
          <div class="display-3">
            <img :src="slide" />
          </div>
        </v-row>
      </v-sheet>
    </v-carousel-item>
  </v-carousel>
</template>
<script>
export default {
  data() {
    return {
      slides: [
        require("@/assets/main/main_img01.jpg"),
        require("@/assets/main/main_img02.jpg"),
        require("@/assets/main/main_img03.jpg")
      ]
    };
  }
};
</script>
e
