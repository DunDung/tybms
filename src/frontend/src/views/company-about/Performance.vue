<template>
  <v-main>
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
      content: "주요 실적",
      subContent: `회사소개   >   주요 실적`,
      backgroundImageUrls: {
        w640: require("@/assets/images/frame/company-about/performance-640.png"),
        w960: require("@/assets/images/frame/company-about/performance-960.png"),
        w1280: require("@/assets/images/frame/company-about/performance-1280.png"),
        w1920: require("@/assets/images/frame/company-about/performance-1920.png")
      }
    },
    imageUrls: [
      require("@/assets/images/content/company-about/performance (1).png"),
      require("@/assets/images/content/company-about/performance (2).png"),
      require("@/assets/images/content/company-about/performance (3).png"),
      require("@/assets/images/content/company-about/performance (4).png"),
      require("@/assets/images/content/company-about/performance (5).png")
    ]
  })
};
</script>
<style scoped></style>
