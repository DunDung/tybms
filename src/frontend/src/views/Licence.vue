<template>
  <v-app>
    <ImageFrame :frame="frame" />
    <SubMenu :subMenus="licenceSubMenus" />
    <Phrase :phrase="phrase" />
    <v-container class="licence-wrap">
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
      return this.licenceSubMenus.filter(subMenu => subMenu.isActive)[0];
    },
    phrase() {
      return {
        title: this.activeSubMenu.englishTitle,
        subTitle: "동양비엠에스 " + this.activeSubMenu.title
      };
    }
  },
  data: () => ({
    licenceSubMenus: [
      {
        title: "특허현황",
        englishTitle: "PATENT",
        images: [require("@/assets/images/licence/patent.jpg")],
        isActive: true
      },
      {
        title: "인증현황",
        englishTitle: "CERTIFICATE",
        images: [require("@/assets/images/licence/certificate.jpg")],
        isActive: false
      },
      {
        title: "면허현황",
        englishTitle: "CONFORMATION",
        images: [require("@/assets/images/licence/conformation.jpg")],
        isActive: false
      }
    ],
    frame: {
      content: "CURRENT SITUATION",
      subContent: "동양BMS 인증 및 특허 현황",
      backgroundImageUrl: require("@/assets/images/frame/frame03.jpg")
    }
  }),
  components: {
    SubMenu,
    ImageFrame,
    Phrase
  }
};
</script>
<style scoped>
    .licence-wrap {
        /*margin-top: -5%;*/
    }
</style>
