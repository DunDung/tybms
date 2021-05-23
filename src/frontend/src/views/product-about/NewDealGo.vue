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
      content: "New deal Go 원격관리 솔루션",
      subContent: `제품소개   >   New deal Go 원격관리 솔루션`,
      backgroundImageUrls: require("@/assets/images/frame/product-about/new-deal-go-1280.png")
    }
  })
};
</script>
<style scoped></style>
