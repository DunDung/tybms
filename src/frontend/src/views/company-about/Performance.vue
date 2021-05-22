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
        backgroundImageUrl: require("@/assets/images/frame/customer-support/archives-1280.png")
      }
    })
  };
</script>
<style scoped></style>
