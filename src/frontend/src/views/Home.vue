<template>
  <v-main class="main-wrap">
    <Slider />
    <div class="wrap">
      <v-card elevation="5" class="cards">
        <v-carousel
          cycle
          hide-delimiter-background
          interval="3000"
          height="100%"
        >
          <v-carousel-item v-for="(slide, i) in slides" :key="i">
            <v-row class="fill-height" align="center" justify="center">
              <v-img :src="slide" />
            </v-row>
          </v-carousel-item>
        </v-carousel>
      </v-card>
      <v-card elevation="5" class="cards">
        <div>Word of the Day</div>
      </v-card>
      <v-card elevation="5" class="cards">
        <div>Word of the Day</div>
      </v-card>
      <v-card elevation="5" class="cards">
        <iframe
                width="100%"
                height="200px"
                src="https://www.youtube.com/embed/hxijtz2WaVs?autoplay=1&amp;mute=1"
          frameborder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          allowfullscreen
        ></iframe>
      </v-card>
    </div>
  </v-main>
</template>
<script>
import Slider from "@/components/Slider";

export default {
  data: () => ({
    slides: [require("@/assets/images/main/home-mini-slider01.png")]
  }),
  components: {
    Slider
  }
};
</script>
<style scoped>
.main-wrap {
}
.wrap {
  margin-top: 3vh;
  margin-bottom: 3vh;
  display: flex;
  flex-direction: row;
  width: 100%;
  justify-content: center;
  /*justify-items: center;*/
  /*align-items: center;*/
  /*align-content: center;*/
}

.cards {
  width: 25%;
  height: 200px;
  margin-left: 0.5vw;
  margin-right: 0.5vw;
}
@media screen and (max-width: 960px) {
  .wrap {
    flex-direction: column;
  }
  .cards {
    margin: 0 auto;
    width: 100%;
  }
}
</style>
