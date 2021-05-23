<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <v-main class="main">
    <ImageFrame :frame="frame" />
    <v-container class="wrap">
      <v-timeline>
        <v-timeline-item
          v-for="(year, n) in years"
          :key="n"
          color="red lighten-2"
          class="ma-10"
        >
          <template v-slot:opposite>
            <span
              :class="`headline font-weight-bold ${year.color}--text`"
              v-text="year.year"
            ></span>
          </template>
          <v-card class="elevation-2">
            <v-card-title class="headline content">
              {{ year.content }}
            </v-card-title>
          </v-card>
        </v-timeline-item>
      </v-timeline>
    </v-container>
  </v-main>
</template>
<script>
import ImageFrame from "@/components/ImageFrame";

export default {
  components: {
    ImageFrame
  },
  data: () => ({
    frame: {
      content: "회사 연혁",
      subContent: `회사소개   >   회사 연혁`,
      backgroundImageUrls: {
        w640: require("@/assets/images/frame/company-about/history-640.png"),
        w960: require("@/assets/images/frame/company-about/history-960.png"),
        w1280: require("@/assets/images/frame/company-about/history-1280.png"),
        w1920: require("@/assets/images/frame/company-about/history-1920.png")
      }
    },
    years: [
      {
        year: "1998",
        content: "동양정보기술 창업, 미국 Invensys 국내 대리점 계약체결"
      },
      {
        year: "1999",
        content: "동양비엠에스 주식회사 법인 전환"
      },
      {
        year: "2002",
        content: "공장 등록(배전반 및 자동제어 제어반 제조업)"
      },
      {
        year: "2005",
        content: "기계설비공사업 면허취득"
      },
      {
        year: "2007",
        content: "Schneider Clipsal 조명제어기기 국내 대리점 계약체결"
      },
      {
        year: "2008",
        content: "Schneider Electric Korea 정식 Partner 체결"
      },
      {
        year: "2010",
        content: "신ᆞ재생에너지 설비설치 전문기업 취득"
      },
      {
        year: "2011",
        content: "BMS Report Program개발"
      },
      {
        year: "2013",
        content: "에너지관리 전문업체 등록, DEMUX Board (Relay Board) 개발 양산"
      },
      {
        year: "2014",
        content: "무선(Zigbee)시스템 개발진행, 에너지 절감 솔루션 전문업체"
      },
      {
        year: "2016",
        content:
          "GS (Good Software 인증) : EBAS-2000, 벤처기업, INNO-BIZ 인증, 특허 취득 (빌딩에너지 절감 유/무선 통합제어기 및 제어시스템)"
      },
      {
        year: "2017",
        content: "우수조달 공동상표 취득 (빌딩제어, 전력감시)"
      },
      {
        year: "2018",
        content:
          "특허인증_로라네트워크를 활용한 사물제어시스템, 특허인증_인공지능모듈형 복합센서"
      }
    ],
    phrase: {
      title: "TYBMS HISTORY",
      subTitle: "동양비엠에스는 이렇게 성장했습니다!"
    }
  })
};
</script>
<style scoped>
.wrap {
  width: 57%;
}
.content {
  font-family: "Do Hyeon", sans-serif !important;
}
</style>
