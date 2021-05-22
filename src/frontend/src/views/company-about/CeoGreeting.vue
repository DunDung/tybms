<template>
  <v-main class="main">
    <Phrase :phrase="phrase" />
    <v-container class="container">
      <div>
        <span class="main-content">
          정직한 제품으로 고객에게 다가설 것이며 <br />
          국내 자동제어시장 최고의 기업이 되겠습니다.
        </span>
        <br /><br />
        <v-progress-linear
                indeterminate
                color="green"
                style="width: 34vw"
        ></v-progress-linear>
        <br />
        <span class="content"
        >동양비엠에스에 오신 것을 환영합니다! <br />
          동양비엠에스는 5년 이상의 노하우를 갖춘 전문 기술인들로 구성된 <br />
          자동제어시스템 전문회사입니다. <br />
          1999년 이래 20여년간 자동제어시스템 설치 및 유지보수를 진행해 왔으며
          <br />
          자체개발을 통한 자동제어 기술은 많은 고객과 클라이언트에게 좋은 평가와
          <br />
          만족을 드리고 있습니다. <br />이에, 저희 동양비엠에스는 항상 고객의
          니즈를 파악하여 <br />
          퀄리티 높은 자동제어시스템 제품을 연구하고 개발하겠습니다.<br />
          솔직한 구매후기와 끊임없는 사랑으로 지켜봐주시길 많은 고객님들께
          진심으로 부탁드립니다. <br />
          항상 진정성을 가지고 노력하는 자동제어시스템 회사가 될 것을 다시 한번
          약속드립니다.</span
        >
        <br /><br />
        <img src="@/assets/images/story/introduction.jpg" />
      </div>
      <div class="right-sort">
        <span class="main-content">
          편리함과 행복을 지키겠다는 동양비엠에스의 사명은<br />
          모든 관계사 임직원들의 최고의 선물이 되겠습니다.
        </span>
        <br /><br />
        <v-progress-linear
                indeterminate
                color="green"
                reverse
                style="float: right; width: 39vw"
        ></v-progress-linear>
        <br />
        <span class="content"
        >동양비엠에스의 노력은 계속됩니다! <br />
          1999년 동양정보기술 창업 이래 슈나이더일렉트릭코리아의
          정식파트너로서<br />
          기술혁신형 중소기업으로서 기틀을 만들었습니다. <br />
          동양비엠에스는 수많은 건설사의 자동제어설비 공사를 통하여 <br />
          많은 기술적 노하우와 원천기술을 갖고 있습니다.<br />
          이와함께 디먹스,빌딩에너지,사물제어시스템,벤처기업,이노비즈 등<br />
          다수의 특허 및 인증을 받으며 자동제어설비업계의 선두주자로서 발판을
          잡았습니다.<br />
          미래를 열어가는 삶!<br />
          그 삶의 중심에 바로 동양비엠에스가 있습니다</span
        >
        <br /><br />
      </div>
      <div class="last-wrap">
        <span id="asd">다양한 경험과 수많은 노하우 </span>
        <h1>지속 가능한 성장을 향해 한 발 앞서 도전하는 기업</h1>
      </div>
    </v-container>
    <v-container class="cards-container">
      <v-card class="mx-auto" max-width="30%">
        <v-img height="100%" src="@/assets/images/story/product.jpg" />
        <v-card-subtitle style="font-size: 1vw">
          동양비엠에스가 갖고있는 놀라운 기술인력과<br />
          20여년간 쌓아온 원천기술이 만나<br />
          최고의 자동제어시스템을 만듭니다.
        </v-card-subtitle>
        <v-card-title class="justify-center">
          제품별 보기
          <v-btn small text to="/#">
            <v-icon>{{ mdiArrowRightBold }}</v-icon>
          </v-btn>
        </v-card-title>
      </v-card>
      <v-card class="mx-auto" max-width="30%">
        <v-img height="100%" src="@/assets/images/story/client-compony.jpg" />
        <v-card-subtitle style="font-size: 1vw">
          고객사의 만족은 저희동양비엠에스의 행복입니다 <br />
          설치와 유지보수,하나도 쉽게 생각하지 않습니다.<br />
          시스템과학! 바로 동양비엠에스이기 때문입니다.<br />
        </v-card-subtitle>
        <v-card-title class="justify-center">
          고객사 보기
          <v-btn small text to="/#">
            <v-icon>{{ mdiArrowRightBold }}</v-icon>
          </v-btn>
        </v-card-title>
      </v-card>
      <v-card class="mx-auto" max-width="30%">
        <v-img
                height="100%"
                src="@/assets/images/story/Installation-case.jpg"
        />
        <v-card-subtitle style="font-size: 1vw">
          국내 굴지의 건설업체 현장엔 항상<br />
          동양비엠에스가 있습니다.<br />
          현장과학! 역시 제품은 동양비엠에스입니다.
        </v-card-subtitle>
        <v-card-title class="justify-center">
          설치 사례 보기
          <v-btn small text to="/#">
            <v-icon>{{ mdiArrowRightBold }}</v-icon>
          </v-btn>
        </v-card-title>
      </v-card>
    </v-container>
  </v-main>
</template>
<script>
  import Phrase from "@/components/Phrase";
  import { mdiArrowRightBold } from "@mdi/js";

  export default {
    data: () => ({
      phrase: {
        title: "TYBMS STORY",
        subTitle: "동양비엠에스에 오신 것을 환영합니다!"
      },
      mdiArrowRightBold: mdiArrowRightBold
    }),
    components: {
      Phrase
    }
  };
</script>
<style scoped>
  .container {
    display: flex;
    flex-direction: column;
    align-items: center;
    font-family: "Noto Sans KR", sans-serif;
  }
  .main-content {
    font-size: 1.7vw;
    letter-spacing: 0.1vw;
  }
  .content {
    line-height: 1.9;
  }
  .right-sort {
    margin-left: auto;
    text-align: right;
  }
  .last-wrap {
    margin-top: 5%;
    text-align: center;
  }
  .last-wrap > span {
    font-size: 2.5vw;
  }
  .last-wrap > h1 {
    font-size: 2.5vw;
  }

  .cards-container {
    display: flex;
    flex-direction: row;
    justify-items: center;
    align-items: center;
    margin-top: 5%;
    font-family: "Noto Sans KR", sans-serif;
  }
</style>
