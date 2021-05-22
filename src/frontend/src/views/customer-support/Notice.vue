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
        backgroundImageUrl: require("@/assets/images/frame/customer-support/notice-1280.png")
      }
    })
  };
</script>
<style scoped></style>
