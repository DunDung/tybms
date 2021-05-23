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
      content: "제품 Specification",
      subContent: `제품소개   >   제품 Specification`,
      backgroundImageUrls: {
        w640: require("@/assets/images/frame/product-about/product-specification-640.png"),
        w960: require("@/assets/images/frame/product-about/product-specification-960.png"),
        w1280: require("@/assets/images/frame/product-about/product-specification-1280.png"),
        w1920: require("@/assets/images/frame/product-about/product-specification-1920.png")
      }
    }
  })
};
</script>
<style scoped></style>
