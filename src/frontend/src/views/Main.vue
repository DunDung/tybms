<template>
  <v-main class="main-wrap">
    <Slider />
    <div class="wrap">
      <v-card elevation="0" rounded="0" class="cards">
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
      <v-card elevation="0" rounded="0" class="cards">
        <section class="notice">
          <h2>NOTICE</h2>
          <router-link class="more" to="/#"
            ><img src="@/assets/images/main/mini-slider/learn-more.png"
          /></router-link>
          <ul>
            <li>
              <a href="#"
                >제 14회 한국국제 냉난반공조전(어쩌고저쩌고)ㅋㅋㅋㅋㅋㅋㅋ</a
              >
            </li>
            <li>
              <a href="#"
                >제 14회 한국국제 냉난반공조전(어쩌고저쩌고)ㅋㅋㅋㅋㅋㅋㅋㅋ</a
              >
            </li>
            <li>
              <a href="#"
                >제 14회 한국국제 냉난반공조전(어쩌고저쩌고)ㅋㅋㅋㅋㅋㅋㅋ</a
              >
            </li>
            <li>
              <a href="#"
                >제 14회 한국국제 냉난반공조전(어쩌고저쩌고)ㅋㅋㅋㅋㅋㅋㅋㅋ</a
              >
            </li>
          </ul>
        </section>
      </v-card>
      <v-card elevation="0" rounded="0" class="cards">
        <section class="notice">
          <h2>TYBMS NEWS</h2>
          <router-link class="more" to="/#"
            ><img src="@/assets/images/main/mini-slider/learn-more.png"
          /></router-link>
          <ul>
            <li>
              <a href="#"
                >제 14회 한국국제
                냉난반공조전(zzzzzzzzzzzzzzzzzzzzzzzzzㅋㅋㅋㅋㅋㅋㅋ</a
              >
            </li>
            <li>
              <a href="#"
                >제 14회 한국국제 냉난반공조전(어쩌고저쩌고)ㅋㅋㅋㅋㅋㅋㅋㅋ</a
              >
            </li>
            <li>
              <a href="#"
                >제 14회 한국국제 냉난반공조전(어쩌고저쩌고)ㅋㅋㅋㅋㅋㅋㅋ</a
              >
            </li>
            <li>
              <a href="#"
                >제 14회 한국국제 냉난반공조전(어쩌고저쩌고)ㅋㅋㅋㅋㅋㅋㅋㅋ</a
              >
            </li>
          </ul>
        </section>
      </v-card>
      <v-card elevation="0" rounded="0" class="cards">
        <iframe
          class="youtube-frame"
          src="https://www.youtube.com/embed/hxijtz2WaVs?autoplay=1&amp;mute=1&amp;playlist=hxijtz2WaVs&amp;loop=1"
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
    slides: [require("@/assets/images/main/mini-slider/home-mini-slider01.png")]
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
}

.cards {
  width: 25%;
  height: 200px;
  margin-left: 0.5vw;
  margin-right: 0.5vw;
}

.notice {
  margin-top: 2.5vh;
  /*margin-left: 0.5vw;*/
  width: 100%;
  position: relative;
  border: 1px solid #000;
  padding: 30px 10px 0;
}

.youtube-frame {
  width: 100%;
}

ul,
li {
  margin: 0;
  padding: 0;
  list-style: none;
}

li {
  border-bottom: 1px dashed #666;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
  padding-bottom: 3px;
  margin-bottom: 10px;
}

li::before {
  content: "";
  display: inline-block;
  width: 5px;
  height: 5px;
  background-color: #666;
  border-radius: 100%;
  line-height: 2;
}

a {
  text-decoration: none;
  color: #ffffff;
  font-weight: bold;
}

h2 {
  position: absolute;
  font-size: 30px;
  left: 20px;
  top: -35px;
  margin: 0;
  background-color: #fff;
  padding: 10px;
}

.more {
  position: absolute;
  left: 270px;
  top: -30px;
  margin-left: -50px;
  padding: 10px 20px;
}

.youtube-frame {
  width: 100%;
  height: 200px;
}

@media screen and (max-width: 960px) {
  .wrap {
    flex-direction: column;
  }

  .cards {
    width: 100%;
    height: auto;
    margin-top: 30px;
  }

  .youtube-frame {
    width: 100%;
    height: 300px;
  }
}
</style>
