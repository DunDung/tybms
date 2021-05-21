<template>
  <v-main>
    <MainSlider />
    <MainCards />
  </v-main>
</template>
<script>
import MainSlider from "@/components/main/MainSlider";
import MainCards from "@/components/main/MainCards";

export default {
  components: {
    MainSlider,
    MainCards
  }
};
</script>
<style scoped></style>
