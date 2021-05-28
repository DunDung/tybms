<template>
  <div class="wrap">
    <v-card elevation="0" rounded="0" class="cards">
      <v-carousel cycle hide-delimiter-background interval="3000" height="100%">
        <v-carousel-item v-for="(slide, i) in slides" :key="i">
          <v-row class="fill-height" align="center" justify="center">
            <img :src="slide" />
          </v-row>
        </v-carousel-item>
      </v-carousel>
    </v-card>
    <v-card elevation="0" rounded="0" class="cards cards-margin-left">
      <section class="notice">
        <h2>공지사항</h2>
        <router-link to="/notice">
          <img
            src="@/assets/images/main/mini-slider/learn-more.png"
            class="more"
          />
        </router-link>
        <ul>
          <li>
            <router-link to="/#">공지사항 11</router-link>
          </li>
          <li>
            <router-link to="/#">공지사항 10</router-link>
          </li>
          <li>
            <router-link to="/#">공지사항 9</router-link>
          </li>
          <li>
            <router-link to="/#">공지사항 8</router-link>
          </li>
        </ul>
      </section>
    </v-card>
    <v-card elevation="0" rounded="0" class="cards cards-margin-left">
      <section class="notice">
        <h2>자료실</h2>
        <router-link to="/archives">
          <img
            src="@/assets/images/main/mini-slider/learn-more.png"
            class="more"
          />
        </router-link>
        <ul>
          <li>
            <router-link to="#">제 11기 주주총회 안내문 </router-link>
          </li>
          <li>
            <router-link to="#">제 10기 주주총회 안내문 </router-link>
          </li>
          <li>
            <router-link to="#">제 9기 주주총회 안내문 </router-link>
          </li>
          <li>
            <router-link to="#">제 8기 주주총회 안내문 </router-link>
          </li>
        </ul>
      </section>
    </v-card>
    <v-card elevation="0" rounded="0" class="cards cards-margin-left">
      <iframe
        class="youtube-frame"
        src="https://www.youtube.com/embed/hxijtz2WaVs?autoplay=1&amp;mute=1&amp;playlist=hxijtz2WaVs&amp;loop=1"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
        allowfullscreen
      ></iframe>
    </v-card>
  </div>
</template>

<script>
export default {
  data: () => ({
    slides: [require("@/assets/images/main/mini-slider/home-mini-slider01.png")]
  })
};
</script>

<style scoped>
.wrap {
  margin-top: 2rem;
  margin-bottom: 2rem;
  display: flex;
  flex-direction: row;
  width: 100%;
  justify-content: center;
}

.cards {
  font-family: "NanumSquare", sans-serif !important;
  width: 25%;
  height: 200px;
}

.cards-margin-left {
  margin-left: 0.8vw;
}

img {
  height: 100%;
  width: 100%;
}

.youtube-frame {
  width: 100%;
}

ul,
li {
  margin: 0;
  padding: 0;
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

.notice {
  margin-top: 1.6vh;
  position: relative;
  width: 100%;
  border: 1px solid #000;
  padding: 30px 10px 0;
}

h2 {
  position: absolute;
  font-size: 33px;
  left: 20px;
  top: -35px;
  margin: 0;
  background-color: #fff;
  padding: 10px;
}

.more {
  width: 145px;
  height: auto;
  position: absolute;
  left: 10.5vw;
  top: -28px;
  padding: 10px 20px;
}

.youtube-frame {
  width: 100%;
  height: 200px;
}

@media screen and (max-width: 960px) {
  .wrap {
    flex-direction: column;
    margin-top: 2px;
  }

  .more {
    left: 60vw;
  }

  .cards {
    width: 100%;
    height: 100%;
    margin-top: 30px;
  }

  .youtube-frame {
    width: 100%;
    height: 300px;
  }
}
</style>
