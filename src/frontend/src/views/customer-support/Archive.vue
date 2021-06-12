<template>
  <v-main>
    <ImageFrame :frame="frame" />
    <DetailPost
      v-if="isViewDetailPost"
      :clickedPost="clickedPost"
      @destroyed="receiveDestroyed"
    />
    <Board :posts="posts" @clickedPost="receiveClickedPost" />
  </v-main>
</template>
<script>
import ImageFrame from "@/components/detail/ImageFrame";
import Board from "@/components/detail/Board";
import DetailPost from "@/components/detail/DetailPost";

export default {
  components: {
    ImageFrame,
    Board,
    DetailPost
  },
  methods: {
    receiveClickedPost(clickedPost) {
      this.clickedPost = clickedPost;
      this.isViewDetailPost = true;
    },
    receiveDestroyed() {
      this.isViewDetailPost = false;
    }
  },
  data: () => ({
    isViewDetailPost: false,
    frame: {
      content: "자료실",
      subContent: `고객지원   >   자료실`,
      backgroundImageUrls: {
        w640: require("@/assets/images/frame/customer-support/archive-640.png"),
        w960: require("@/assets/images/frame/customer-support/archive-960.png"),
        w1280: require("@/assets/images/frame/customer-support/archive-1280.png"),
        w1920: require("@/assets/images/frame/customer-support/archive-1920.png")
      }
    },
    clickedPost: {},
    posts: [
      {
        id: 1,
        title: "2021 동양BMS 회사지명원",
        content: "",
        updatedDate: "2021.06.09",
        views: 24,
        attachedFiles: [
          {
            fileName: "2021 동양BMS_회사지명원.pdf",
            fileUrl: require("@/assets/upload-files/2021 동양BMS_회사지명원.pdf")
          }
        ]
      }
    ]
  })
};
</script>
<style scoped></style>
