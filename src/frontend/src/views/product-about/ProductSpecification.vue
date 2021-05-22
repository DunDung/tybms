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
      backgroundImageUrl: require("@/assets/images/frame/product-about/product-specification-1280.png")
    }
  })
};
</script>
<style scoped></style>
