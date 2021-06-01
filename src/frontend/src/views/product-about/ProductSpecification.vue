<template>
  <v-main>
    <ImageFrame :frame="frame" />
    <Board :posts="posts" />
  </v-main>
</template>
<script>
import ImageFrame from "@/components/ImageFrame";
import Board from "@/components/Board";

export default {
  components: {
    ImageFrame,
    Board
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
        title: "제품 1",
        updatedDate: "2021.05.13",
        views: 24
      },
      {
        id: 2,
        title: "제품 2",
        updatedDate: "2021.05.14",
        views: 21
      },
      {
        id: 3,
        title: "제품 3",
        updatedDate: "2021.05.15",
        views: 25
      },
      {
        id: 4,
        title: "제품 4",
        updatedDate: "2021.05.16",
        views: 27
      },
      {
        id: 5,
        title: "제품 5",
        updatedDate: "2021.05.17",
        views: 2
      }
    ]
  })
};
</script>
<style scoped></style>
