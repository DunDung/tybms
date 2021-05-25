<template>
  <v-main>
    <ImageFrame :frame="frame" />
    <ImageContent :image-url="imageUrl" />
  </v-main>
</template>
<script>
import ImageFrame from "@/components/ImageFrame";
import ImageContent from "@/components/ImageContent";

export default {
  data: () => ({
    frame: {
      content: "찾아오시는 길",
      subContent: `회사소개   >   찾아오시는 길`,
      backgroundImageUrls: {
        w640: require("@/assets/images/frame/company-about/contact-640.png"),
        w960: require("@/assets/images/frame/company-about/contact-960.png"),
        w1280: require("@/assets/images/frame/company-about/contact-1280.png"),
        w1920: require("@/assets/images/frame/company-about/contact-1920.png")
      }
    },
    imageUrl: require("@/assets/images/content/company-about/directions.png")
  }),
  components: {
    ImageContent,
    ImageFrame
  }
};
</script>
<style scoped></style>
