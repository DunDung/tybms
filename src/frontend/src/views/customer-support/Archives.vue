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
      content: "자료실",
      subContent: `고객지원   >   자료실`,
      backgroundImageUrls: {
        w640: require("@/assets/images/frame/customer-support/archives-640.png"),
        w960: require("@/assets/images/frame/customer-support/archives-960.png"),
        w1280: require("@/assets/images/frame/customer-support/archives-1280.png"),
        w1920: require("@/assets/images/frame/customer-support/archives-1920.png")
      }
    }
  })
};
</script>
<style scoped></style>
