<template>
  <v-container class="wrap">
    <img :src="imageUrl" />
  </v-container>
</template>
<script>
export default {
  props: ["imageUrl"]
};
</script>
<style scoped>
  .wrap {
    margin-top: 1.5vw;
    margin-bottom: 1.5vw;
    padding: 0;
    width: 100%;
    text-align: center;
  }
  img {
    max-width: 80%;
    height: auto;
  }
</style>
