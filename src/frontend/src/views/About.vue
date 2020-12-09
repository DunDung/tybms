<template>
  <v-app>
    <ImageFrame :frame="frame" />
    <SubMenu :subMenus="aboutSubMenus" />
    <Story v-if="aboutSubMenus[0].isActive" />
    <History v-if="aboutSubMenus[1].isActive" />
    <Contact v-if="aboutSubMenus[2].isActive" />
  </v-app>
</template>
<script>
import SubMenu from "@/components/SubMenu";
import ImageFrame from "@/components/ImageFrame";
import Story from "@/components/Story";
import History from "@/components/History";
import Contact from "@/components/Contact";

export default {
  data: () => ({
    aboutSubMenus: [
      {
        title: "동양BMS 이야기",
        isActive: true
      },
      {
        title: "동양BMS 연혁",
        isActive: false
      },
      {
        title: "찾아오시는 길",
        isActive: false
      }
    ],
    frame: {
      content: "CORPORATE INNOVATION",
      subContent: "혁신기업! 동양BMS(주)",
      backgroundImageUrl: require("@/assets/images/frame/frame01.jpg")
    }
  }),
  components: {
    SubMenu,
    Story,
    ImageFrame,
    History,
    Contact
  }
};
</script>
<style scoped></style>
