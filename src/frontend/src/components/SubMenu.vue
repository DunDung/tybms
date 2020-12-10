<template>
  <v-container class="container">
    <v-tabs center-active light centered grow show-arrows class="sub-menus" color="black" >
      <v-tab
        class="menu"
        v-for="(subMenu, index) in subMenus"
        :key="index"
        @click="active(index)"
      >
        {{ subMenu.title }}
      </v-tab>
    </v-tabs>
  </v-container>
</template>
<script>
export default {
  props: ["subMenus"],
  data() {
    return {
      activeIndex: 0
    };
  },
  methods: {
    active(index) {
      this.subMenus[this.activeIndex].isActive = false;
      this.subMenus[index].isActive = true;
      this.activeIndex = index;
    }
  }
};
</script>
<style scoped>
.container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  justify-items: center;
  align-items: center;
}
.sub-menus {
  max-width: 70%;
  margin-top: 1vw;
  font-family: "Noto Sans KR", sans-serif;
}

.menu {
  font-size: 1vw;
  margin: 0.3vw;
  border: 1px solid #dcdcdc;
}
</style>
