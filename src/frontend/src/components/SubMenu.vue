<template>
  <v-container class="container">
    <v-tabs
      center-active
      light
      :centered="true"
      class="sub-menus"
      color="black"
    >
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
}
.sub-menus {
  max-width: 70%;
  margin: 0 auto;
}
.menu {
  margin: 0.3vw;
  border: 1px solid #dcdcdc;
}
</style>
