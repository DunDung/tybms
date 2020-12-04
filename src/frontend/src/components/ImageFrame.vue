<template>
  <v-container
    class="image-container"
    :fluid="true"
    background-color="red"
    :style="{'background-image': 'url(' + backgroundImageUrl + ')'}"
  >
    <span class="content">{{ content }}</span>
    <br />
    <span class="sub-content">{{ subContent }}</span>
  </v-container>
</template>
<script>
export default {
  data() {
    return {
      content: "CORPORATE INNOVATION",
      subContent: "혁신기업! 동양BMS(주)",
      backgroundImageUrl: require("@/assets/images/card/card01.jpg")
    };
  }
};
</script>
<style scoped>
.image-container {
  height: 18vw;
  background-size: 100%;
  background-attachment: fixed;
  opacity: 90%;
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
