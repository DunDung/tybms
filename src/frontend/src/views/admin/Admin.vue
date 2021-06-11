<template>
  <v-main>
    <v-card rounded="0">
      <v-tabs background-color="#1A9A1A" center-active centered dark>
        <v-tab to="/" v-for="(menu, index) in menus" :key="index" class="menu">
          {{ menu }}
        </v-tab>
      </v-tabs>
    </v-card>
    <NoticeAdmin />
  </v-main>
</template>
<script>
import EventBus from "@/event-bus/EventBus.js";
import NoticeAdmin from "@/components/admin/NoticeAdmin"
export default {
  created() {
    EventBus.$emit("admin", true);
  },
  destroyed() {
    EventBus.$emit("admin", false);
  },
  components: {
    NoticeAdmin
  },
  data: () => ({
    menus: ["공지사항", "자료실", "제품 카다로그"]
  })
};
</script>
<style scoped>
.menu {
  width: 20%;
}
</style>
