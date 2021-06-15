<template>
  <v-main>
    <MainSlider />
    <MainCards />
  </v-main>
</template>
<script>
import MainSlider from "@/components/main/MainSlider";
import MainCards from "@/components/main/MainCards";
import { mapActions } from "vuex";

export default {
  created() {
    this.requestResource();
  },
  components: {
    MainSlider,
    MainCards
  },
  methods: {
    ...mapActions(["requestResource"])
  }
};
</script>
<style scoped></style>
