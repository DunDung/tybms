<template>
  <v-btn
    v-scroll="onScroll"
    v-show="fab"
    fab
    dark
    fixed
    bottom
    right
    color="#1A9A1A"
    @click="toTop"
  >
    <v-icon>{{ mdiArrowUp }}</v-icon>
  </v-btn>
</template>
<script>
import { mdiArrowUp } from "@mdi/js";
export default {
  methods: {
    onScroll(e) {
      if (typeof window === "undefined") return;
      const top = window.pageYOffset || e.target.scrollTop || 0;
      this.fab = top > 20;
    },
    toTop() {
      window.scrollTo({ top: 0, left: 0, behavior: "smooth" });
    }
  },
  data: () => ({
    fab: false,
    mdiArrowUp: mdiArrowUp
  })
};
</script>
