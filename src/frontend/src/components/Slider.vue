<template>
  <v-main>
    <v-carousel
      cycle
      max-height="100%"
      hide-delimiter-background
      show-arrows-on-hover
    >
      <v-carousel-item v-for="(slide, i) in slides" :key="i">
        <v-sheet max-height="80%">
          <v-row class="fill-height" align="center" justify="center">
            <div class="display-3">
              <v-img :src="slide" max-width="100%" height="auto" />
            </div>
          </v-row>
        </v-sheet>
      </v-carousel-item>
    </v-carousel>
  </v-main>
</template>
<script>
export default {
  data() {
    return {
      slides: [
        require("@/assets/main/main-img01.jpg"),
        require("@/assets/main/main-img02.jpg"),
        require("@/assets/main/main-img03.jpg")
      ]
    };
  }
};
</script>
e
