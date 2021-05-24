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
      content: "그린뉴딜 고 산업안전환경 솔루션",
      subContent: `제품소개   >   그린뉴딜 고 산업안전환경 솔루션`,
      backgroundImageUrls: {
        w640: require("@/assets/images/frame/product-about/green-new-deal-go-640.png"),
        w960: require("@/assets/images/frame/product-about/green-new-deal-go-960.png"),
        w1280: require("@/assets/images/frame/product-about/green-new-deal-go-1280.png"),
        w1920: require("@/assets/images/frame/product-about/green-new-deal-go-1920.png")
      }
    }
  })
};
</script>
<style scoped></style>
