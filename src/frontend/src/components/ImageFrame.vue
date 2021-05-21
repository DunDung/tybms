<template>
  <v-container
    class="image-container"
    fluid
  >
<!--    <img :src="frame.backgroundImageUrls.w1920">-->
<!--    :style="{ 'background-image': 'url(' + frame.backgroundImageUrls.w1920 + ')' }"-->
    <span class="content">{{ frame.content }}</span>
    <br />
    <span class="sub-content">{{ frame.subContent }}</span>
  </v-container>
</template>
<script>
export default {
  props: ["frame"]
};
</script>
<style scoped>
  img {
    width: 100%;
    height: 100%;
  }
.image-container {
  height: 400px;
  background-size: 100%;
  background-attachment: fixed;
  background-position: bottom;
  background-repeat: repeat-y;
  opacity: 0.9;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.content {
  font-size: 2.6vw;
  letter-spacing: 0.1vw;
  font-family: "Do Hyeon", sans-serif;
}
.sub-content {
  color: #c0c0c0;
  font-size: 1.2vw;
  font-family: "Noto Sans KR", sans-serif;
}
</style>
