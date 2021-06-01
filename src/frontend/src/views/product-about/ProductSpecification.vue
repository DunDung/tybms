<template>
  <v-main>
    <ImageFrame :frame="frame" />
    <ProductBoard :posts="posts" />
  </v-main>
</template>
<script>
import ImageFrame from "@/components/ImageFrame";
import ProductBoard from "@/components/ProductBoard";

export default {
  components: {
    ImageFrame,
    ProductBoard
  },
  data: () => ({
    frame: {
      content: "제품 카다로그",
      subContent: `제품소개   >   제품 카다로그`,
      backgroundImageUrls: {
        w640: require("@/assets/images/frame/product-about/product-specification-640.png"),
        w960: require("@/assets/images/frame/product-about/product-specification-960.png"),
        w1280: require("@/assets/images/frame/product-about/product-specification-1280.png"),
        w1920: require("@/assets/images/frame/product-about/product-specification-1920.png")
      }
    },
    posts: [
      {
        id: 1,
        title: "AQS Series CATALOG",
        updatedDate: "2021.05.13",
        views: 24,
        fileUrl: require("@/assets/pdf/AQS-Series-CATALOG.pdf")
      },
    ]
  })
};
</script>
<style scoped></style>
