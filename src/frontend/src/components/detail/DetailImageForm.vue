<template>
  <v-container class="wrap">
    <div v-for="(imageUrl, i) in imageUrls" :key="i">
      <img :src="imageUrl" />
    </div>
  </v-container>
</template>
<script>
export default {
  props: ["imageUrls"]
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

@media screen and (max-width: 960px) {
  img {
    max-width: 100%;
  }
}
</style>
