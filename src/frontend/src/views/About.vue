<template>
  <v-app>
    <ImageFrame :frame="frame" />
    <SubMenu :subMenus="aboutSubMenus" />
    <Story v-if="aboutSubMenus[0].isActive" />
  </v-app>
</template>
<script>
import SubMenu from "@/components/SubMenu";
import Story from "@/components/Story";
import ImageFrame from "@/components/ImageFrame";

export default {
  data() {
    return {
      aboutSubMenus: [
        {
          title: "동양BMS 스토리",
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
    };
  },
  components: {
    SubMenu,
    Story,
    ImageFrame
  }
};
</script>
<style scoped></style>
