<template>
  <v-main>
    <ImageFrame :frame="frame" />
    <ImageContent :image-url="imageUrl" />
  </v-main>
</template>
<script>
import ImageFrame from "@/components/ImageFrame";
import ImageContent from "@/components/ImageContent";

export default {
  components: {
    ImageFrame, ImageContent
  },
  data: () => ({
    frame: {
      content: "뉴딜 고 원격관리 솔루션",
      subContent: `제품소개   >   뉴딜 고 원격관리 솔루션`,
      backgroundImageUrls: {
        w640: require("@/assets/images/frame/product-about/new-deal-go-640.png"),
        w960: require("@/assets/images/frame/product-about/new-deal-go-960.png"),
        w1280: require("@/assets/images/frame/product-about/new-deal-go-1280.png"),
        w1920: require("@/assets/images/frame/product-about/new-deal-go-1920.png")
      }
    },
    imageUrl: require("@/assets/images/content/product-about/new-deal-go.png")
  })
};
</script>
<style scoped></style>
