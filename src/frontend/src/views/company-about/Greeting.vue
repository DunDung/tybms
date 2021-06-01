<template>
  <v-main>
    <ImageFrame :frame="frame" />
    <ImageContent :image-urls="imageUrls" />
  </v-main>
</template>
<script>
import { mdiArrowRightBold } from "@mdi/js";
import ImageFrame from "@/components/ImageFrame";
import ImageContent from "@/components/ImageContent";

export default {
  components: {
    ImageFrame,
    ImageContent
  },
  data: () => ({
    frame: {
      content: "CEO 인사",
      subContent: `회사소개   >   CEO 인사`,
      backgroundImageUrls: {
        w640: require("@/assets/images/frame/company-about/ceo-greeting-640.png"),
        w960: require("@/assets/images/frame/company-about/ceo-greeting-960.png"),
        w1280: require("@/assets/images/frame/company-about/ceo-greeting-1280.png"),
        w1920: require("@/assets/images/frame/company-about/ceo-greeting-1920.png")
      }
    },
    imageUrls: [
      require("@/assets/images/content/company-about/ceo-greeting.jpg")
    ],
    mdiArrowRightBold: mdiArrowRightBold
  })
};
</script>
<style scoped></style>
