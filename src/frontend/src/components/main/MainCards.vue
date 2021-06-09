<template>
  <div class="wrap">
    <MiniSlider />
    <v-card elevation="0" rounded="0" class="cards cards-margin-left">
      <section class="notice">
        <table width="100%">
          <tr>
            <td width="43%" align="center">
              <h2>공지사항</h2>
            </td>
            <td width="60%" align="center">
              <router-link to="/notice">
                <img
                  src="@/assets/images/main/mini-slider/learn-more.png"
                  class="more"
                />
              </router-link>
            </td>
          </tr>
        </table>

        <ul>
          <li>
            <router-link to="/#">2021.04.26 기계설비신문 기사 게재</router-link>
          </li>
        </ul>
      </section>
    </v-card>
    <v-card elevation="0" rounded="0" class="cards cards-margin-left">
      <section class="notice">
        <table width="100%">
          <tr>
            <td width="20%" align="center">
              <h2>자료실</h2>
            </td>
            <td width="20%" align="center">
              <router-link to="/archives">
                <img
                  src="@/assets/images/main/mini-slider/learn-more.png"
                  class="more"
                />
              </router-link>
            </td>
          </tr>
        </table>

        <ul>
          <li>
            <router-link to="#">2021 동양BMS 회사지명원</router-link>
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
import MiniSlider from "@/components/main/MiniSlider";
export default {
  components: {
    MiniSlider
  }
};
</script>

<style scoped>
.wrap {
  margin-top: 2.3rem;
  margin-bottom: 1rem;
  display: flex;
  flex-direction: row;
  width: 100%;
  justify-content: center;
}

.cards {
  width: 25%;
  height: 350px;
}

.cards-margin-left {
  margin-left: 0.8vw;
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
  border: 1px solid black;
  padding: 30px 10px 0;
  height: 100%;
  font-family: "Nanum Gothic", sans-serif;
}
table {
  position: absolute;
  top: -1.2vw;
}
h2 {
  font-size: 1.7vw;
  margin: 0;
  background-color: #fff;
  cursor: default;
}

.more {
  width: 6vw;
  height: auto;
}

.youtube-frame {
  width: 100%;
  height: 100%;
}

@media screen and (max-width: 960px) {
  .wrap {
    flex-direction: column;
    margin-top: -20px;
  }
  @media screen and (min-width: 551px) {
    table {
      position: absolute;
      top: -3.35vw;
    }

    h2 {
      font-size: 4.2vw;
      margin: 0;
      background-color: #fff;
    }

    .more {
      width: 18vw;
      height: auto;
    }
  }

  .cards {
    width: 100%;
    height: 100%;
    margin-top: 40px;
  }

  .cards-margin-left {
    margin-left: 0;
  }

  .youtube-frame {
    width: 100%;
    height: 300px;
  }
}
@media screen and (max-width: 550px) {
  table {
    position: absolute;
    top: -5.5vw;
  }
  h2 {
    font-size: 7.5vw;
    margin: 0;
    background-color: #fff;
  }

  .more {
    width: 27.5vw;
    height: auto;
  }
}
</style>
