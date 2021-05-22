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
      content: "Smart Go 유무선 분산시스템 솔루션",
      subContent: `제품소개   >   Smart Go 유무선 분산시스템 솔루션`,
      backgroundImageUrl: require("@/assets/images/frame/product-about/smart-go-1280.png")
    }
  })
};
</script>
<style scoped></style>
