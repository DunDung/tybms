<template>
  <v-main>
    <ImageFrame :frame="frame" />
    <ProductBoard :products="getProducts" />
  </v-main>
</template>
<script>
import ImageFrame from "@/components/detail/ImageFrame";
import ProductBoard from "@/components/detail/ProductBoard";
import { mapGetters } from "vuex";

export default {
  components: {
    ImageFrame,
    ProductBoard
  },
  computed: {
    ...mapGetters(["getProducts"])
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
  })
};
</script>
<style scoped></style>
