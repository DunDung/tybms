<template>
  <v-main>
    <v-card rounded="0" class="wrap">
      <v-tabs background-color="#1A9A1A" center-active centered dark>
        <v-tab
          @click="handleAdmin(index)"
          v-for="(menu, index) in menus"
          :key="index"
          class="menu"
        >
          {{ menu.name }}
        </v-tab>
      </v-tabs>
    </v-card>
    <BoardAdmin :component="component" />
  </v-main>
</template>
<script>
import EventBus from "@/event-bus/EventBus.js";
import BoardAdmin from "@/components/admin/BoardAdmin";
export default {
  created() {
    EventBus.$emit("admin", true);
  },
  destroyed() {
    EventBus.$emit("admin", false);
  },
  components: {
    BoardAdmin
  },
  data: () => ({
    menus: [
      {
        name: "공지사항",
        uri: "/notices"
      },
      {
        name: "자료실",
        uri: "/archives"
      },
      {
        name: "제품 카다로그",
        uri: "/notices"
      },
      {
        name: "홈페이지로 돌아가기",
        uri: "/"
      }
    ],
    component: {
      name: "공지사항",
      uri: "/notices"
    }
  }),
  methods: {
    handleAdmin(index) {
      if (index == 3) {
        this.$router.push("/");
      }
      this.component = this.menus[index];
    }
  }
};
</script>
<style scoped>
.wrap {
  margin-bottom: 1vw;
}
.menu {
  width: 20%;
}
</style>
