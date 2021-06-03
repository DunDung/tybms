<template>
  <div class="wrap">
    <v-card elevation="0" rounded="0" class="cards">
      <v-carousel cycle hide-delimiter-background interval="3000" height="100%">
        <v-carousel-item v-for="(slide, i) in slides" :key="i">
          <v-row class="fill-height" align="center" justify="center">
            <picture>
              <source :srcset="slide.w320" media="(max-width: 400px)" />
              <source :srcset="slide.w640" media="(max-width: 640px)" />
              <source :srcset="slide.w960" media="(max-width: 960px)" />
              <source :srcset="slide.w320" media="(max-width: 1920px)" />
              <img :src="slide.w320" />
            </picture>
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
          <li>
            <router-link to="/#">공지사항 7</router-link>
          </li>
          <li>
            <router-link to="/#">공지사항 6</router-link>
          </li>
          <li>
            <router-link to="/#">공지사항 5</router-link>
          </li>
          <li>
            <router-link to="/#">공지사항 4</router-link>
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
          <li>
            <router-link to="#">제 7기 주주총회 안내문 </router-link>
          </li>
          <li>
            <router-link to="#">제 6기 주주총회 안내문 </router-link>
          </li>
          <li>
            <router-link to="#">제 5기 주주총회 안내문 </router-link>
          </li>
          <li>
            <router-link to="#">제 4기 주주총회 안내문 </router-link>
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
    slides: [
      {
        w320: require("@/assets/images/main/mini-slider/mini-slider-1-320.png"),
        w640: require("@/assets/images/main/mini-slider/mini-slider-1-640.png"),
        w960: require("@/assets/images/main/mini-slider/mini-slider-1-960.png"),
      },
      {
        w320: require("@/assets/images/main/mini-slider/mini-slider-2-320.png"),
        w640: require("@/assets/images/main/mini-slider/mini-slider-2-640.png"),
        w960: require("@/assets/images/main/mini-slider/mini-slider-2-960.png"),
      }
    ]
  })
};
</script>

<style scoped>
.wrap {
  margin-top: 2.3rem;
  margin-bottom: 2.3rem;
  display: flex;
  flex-direction: row;
  width: 100%;
  justify-content: center;
}

.cards {
  font-family: "NanumSquare", sans-serif !important;
  width: 25%;
  height: 350px;
}

.cards-margin-left {
  margin-left: 0.8vw;
}

img {
  width: 100%;
  height: 100%;
  object-fit: fill;

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
  border-bottom: 1px dashed black;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
  padding-bottom: 3px;
  margin-bottom: 13px;
}

li::before {
  content: "";
  display: inline-block;
  width: 5px;
  height: 5px;
  background-color: black;
  border-radius: 100%;
  line-height: 2;
  margin-right: 5px;
}

a {
  text-decoration: none;
  color: blue;
  font-weight: bold;
}

.notice {
  position: relative;
  width: 100%;
  border: 1px solid #000;
  padding: 30px 10px 0;
  height: 100%;
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
  height: 100%;
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
