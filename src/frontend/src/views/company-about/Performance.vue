<template>
  <ImageFrame :frame="frame" />
</template>
<script>
import ImageFrame from "@/components/ImageFrame";

export default {
  components: {
    ImageFrame
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
    }
  })
};
</script>
<style scoped></style>
