<template>
  <v-container class="image-container pa-0" fluid>
    <picture>
      <source
        :srcset="frame.backgroundImageUrls.w640"
        media="(max-width: 640px)"
      />
      <source
        :srcset="frame.backgroundImageUrls.w960"
        media="(max-width: 960px)"
      />
      <source
        :srcset="frame.backgroundImageUrls.w1280"
        media="(max-width: 1280px)"
      />
      <source
        :srcset="frame.backgroundImageUrls.w1920"
        media="(max-width: 1920px)"
      />
      <img :src="frame.backgroundImageUrls.w1280" />
    </picture>
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
picture,
source,
img {
  position: absolute;
  width: 100%;
  height: 300px;
  object-fit: cover;
  z-index: 1;
  /*opacity: 0.8;*/
}

span {
  z-index: 2;
  color: white;
  white-space: pre;
}
.image-container {
  max-width: 100%;
  height: 300px;
  overflow: hidden;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.content {
  font-size: 4vw;
  letter-spacing: 0.1vw;
  font-family: "Do Hyeon", sans-serif;
}
.sub-content {
  color: #c0c0c0;
  font-size: 1.4vw;
  font-family: "Noto Sans KR", sans-serif;
}

@media screen and (max-width: 960px) {
  .image-container,
  picture,
  source,
  img {
    height: 150px;
  }

  .content {
    font-size: 6vw;
  }
  .sub-content {
    font-size: 3vw;
  }
}
</style>
