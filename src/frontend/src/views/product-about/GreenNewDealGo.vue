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
      content: "Green New deal Go 산업안전환경 솔루션",
      subContent: `제품소개   >   Green New deal Go 산업안전환경 솔루션`,
      backgroundImageUrl: require("@/assets/images/frame/product-about/green-new-deal-go-1280.png")
    }
  })
};
</script>
<style scoped></style>
