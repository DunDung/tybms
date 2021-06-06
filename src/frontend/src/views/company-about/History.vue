<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <v-main class="main">
    <ImageFrame :frame="frame" />
    <ContentImageForm :image-urls="imageUrls" />
  </v-main>
</template>
<script>
import ImageFrame from "@/components/detail/ImageFrame";
import ContentImageForm from "@/components/detail/ContentImageForm";

export default {
  components: {
    ImageFrame,
    ContentImageForm
  },
  data: () => ({
    frame: {
      content: "회사 연혁",
      subContent: `회사소개   >   회사 연혁`,
      backgroundImageUrls: {
        w640: require("@/assets/images/frame/company-about/history-640.png"),
        w960: require("@/assets/images/frame/company-about/history-960.png"),
        w1280: require("@/assets/images/frame/company-about/history-1280.png"),
        w1920: require("@/assets/images/frame/company-about/history-1920.png")
      }
    },
    imageUrls: [require("@/assets/images/content/company-about/time-line.jpg")]
  })
};
</script>
<style scoped></style>
