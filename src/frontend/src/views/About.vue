<template>
  <v-app>
    <SubMenu :subMenus="aboutSubMenus" />
    <Story v-if="aboutSubMenus[0].isActive" />
  </v-app>
</template>
<script>
import SubMenu from "@/components/SubMenu";
import Story from "@/components/Story";

export default {
  data() {
    return {
      aboutSubMenus: [
        {
          title: "동양비엠에스 스토리",
          isActive: true
        },
        {
          title: "동양비엠에스 연혁",
          isActive: false
        },
        {
          title: "찾아오시는 길",
          isActive: false
        }
      ]
    };
  },
  components: {
    SubMenu,
    Story
  }
};
</script>
<style scoped></style>
