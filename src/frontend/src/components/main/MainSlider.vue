<template>
  <v-carousel cycle hide-delimiter-background interval="3000">
    <v-carousel-item v-for="(slide, i) in slides" :key="i">
      <v-row class="fill-height slider-wrap" align="center" justify="center">
        <picture>
          <source :srcset="slide.w320" media="(max-width: 400px)" />
          <source :srcset="slide.w640" media="(max-width: 640px)" />
          <source :srcset="slide.w960" media="(max-width: 960px)" />
          <source :srcset="slide.w1280" media="(max-width: 1280px)" />
          <source :srcset="slide.w1920" media="(max-width: 1920px)" />
          <img :src="slide.w1920" />
        </picture>
        <span class="content">{{ slide.content }}</span>
        <br/>
        <span class="sub-content">{{ slide.subContent }}</span>
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
          content: "첨단 자동제어시스템(IoT&AI)을 선도하는 기업",
          subContent: "동양 BMS(주)",
          w320: require("@/assets/images/main/main-slider/1(320).png"),
          w640: require("@/assets/images/main/main-slider/1(640).png"),
          w960: require("@/assets/images/main/main-slider/1(960).png"),
          w1280: require("@/assets/images/main/main-slider/1(1280).png"),
          w1920: require("@/assets/images/main/main-slider/1(1920).png")
        },
        {
          content: "GREEN NEW DEAL GO",
          subContent: "산업안전환경 솔루션",
          w320: require("@/assets/images/main/main-slider/2(320).png"),
          w640: require("@/assets/images/main/main-slider/2(640).png"),
          w960: require("@/assets/images/main/main-slider/2(960).png"),
          w1280: require("@/assets/images/main/main-slider/2(1280).png"),
          w1920: require("@/assets/images/main/main-slider/2(1920).png")
        },
        {
          content: "SMART GO",
          subContent: "유·무선 분산시스템 솔루션",
          w320: require("@/assets/images/main/main-slider/3(320).png"),
          w640: require("@/assets/images/main/main-slider/3(640).png"),
          w960: require("@/assets/images/main/main-slider/3(960).png"),
          w1280: require("@/assets/images/main/main-slider/3(1280).png"),
          w1920: require("@/assets/images/main/main-slider/3(1920).png")
        },
        {
          content: "NEW DEAL GO",
          subContent: "원격관리 솔루션",
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

  .slider-wrap {
    overflow: hidden;
    display: flex;
    flex-direction: column;
  }

  picture,
  source,
  img {
    position: absolute;
    width: 100%;
    height: 500px;
    object-fit: cover;
    z-index: 1;
  }

  span {
    z-index: 2;
    color: white;
    font-size: 4vw;
    letter-spacing: 0.2vw;
     font-family: "Do Hyeon", sans-serif;
  }

  /*슬라이더 모바일 처리*/
  @media screen and (max-width: 960px) {
    .fill-height
    picture,
    source,
    img {

    }

    .content {
      font-size: 6vw;
    }
    .sub-content {
      font-size: 3vw;
    }
  }

</style>
