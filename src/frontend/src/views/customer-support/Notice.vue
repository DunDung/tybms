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
      content: "공지사항",
      subContent: `고객지원   >   공지사항`,
      backgroundImageUrls: {
        w640: require("@/assets/images/frame/customer-support/notice-640.png"),
        w960: require("@/assets/images/frame/customer-support/notice-960.png"),
        w1280: require("@/assets/images/frame/customer-support/notice-1280.png"),
        w1920: require("@/assets/images/frame/customer-support/notice-1920.png")
      }
    }
  })
};
</script>
<style scoped></style>
