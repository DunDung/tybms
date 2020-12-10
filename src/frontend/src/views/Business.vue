<template>
  <v-app>
    <ImageFrame :frame="frame" />
    <SubMenu :subMenus="businessSubMenus" />
    <Phrase :phrase="phrase" />
    <v-container>
      <v-img
        v-for="(image, index) in activeSubMenu.images"
        :key="index"
        :src="image"
      />
    </v-container>
  </v-app>
</template>
<script>
import SubMenu from "@/components/SubMenu";
import ImageFrame from "@/components/ImageFrame";
import Phrase from "@/components/Phrase";

export default {
  computed: {
    activeSubMenu() {
      return this.businessSubMenus.filter(subMenu => subMenu.isActive)[0];
    },
    phrase() {
      return {
        title: this.activeSubMenu.title,
        subTitle: "동양비엠에스 " + this.activeSubMenu.title
      };
    }
  },
  data: () => ({
    businessSubMenus: [
      {
        title: "HMI & BEMS",
        images: [require("@/assets/images/business/hmi-bems.png")],
        isActive: true
      },
      {
        title: "DDC CONTROLLER",
        images: [
          require("@/assets/images/business/ddc-controller01.png"),
          require("@/assets/images/business/ddc-controller02.png")
        ],
        isActive: false
      },
      {
        title: "IoT WIRELESS",
        images: [
          require("@/assets/images/business/iot-solution01.png"),
          require("@/assets/images/business/iot-solution02.png")
        ],
        isActive: false
      },
      {
        title: "AQS SERIES",
        images: [
          require("@/assets/images/business/aqs-series01.png"),
          require("@/assets/images/business/aqs-series02.png")
        ],
        isActive: false
      },
      {
        title: "MULTI GATEWAY",
        images: [require("@/assets/images/business/multi-gateway.png")],
        isActive: false
      },
      {
        title: "CONTACTLESS TEMPERTURE SENSOR",
        images: [
          require("@/assets/images/business/contactless-temperture-sensor.png")
        ],
        isActive: false
      },
      {
        title: "SMART DISPLAY",
        images: [require("@/assets/images/business/smart-display.png")],
        isActive: false
      },
      {
        title: "LIGHT CONTROLL",
        images: [require("@/assets/images/business/lighting-control.png")],
        isActive: false
      },
      {
        title: "SYSTEM ARCHITECTURE",
        images: [require("@/assets/images/business/system-architecture.png")],
        isActive: false
      }
    ],
    frame: {
      content: "BUSINESS INNOVATION",
      subContent: "동양BMS 핵심 사업 분야",
      backgroundImageUrl: require("@/assets/images/frame/frame02.jpg")
    }
  }),
  components: {
    SubMenu,
    ImageFrame,
    Phrase
  }
};
</script>
<style scoped></style>
