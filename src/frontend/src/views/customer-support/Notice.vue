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
      content: "공지사항",
      subContent: `고객지원   >   공지사항`,
      backgroundImageUrls: {
        w640: require("@/assets/images/frame/customer-support/notice-640.png"),
        w960: require("@/assets/images/frame/customer-support/notice-960.png"),
        w1280: require("@/assets/images/frame/customer-support/notice-1280.png"),
        w1920: require("@/assets/images/frame/customer-support/notice-1920.png")
      }
    },
    posts: [
      {
        id: 1,
        title: "2021.04.26 기계설비신문 기사 게재",
        content: `자동제어전문기업 동양BMS는 기존 빌딩자동제어 사업을 바탕으로 산업환경 안전분야, 골프장 자동제어 등으로 사업을 다각화하며 사세 확장에 나서고 있다.
4차 산업혁명시대를 맞이하고 그린뉴딜정책이 추진되는 상황에서 IoT 기술과 접목된 다양한 기술을 지속적으로 개발하고 이를 적용할 수 있는 현장을 꾸준히 발굴해
사업영역을 확대해 나갈 예정이라고 얘기했다.`,
        updatedDate: "2021.06.09",
        views: 24,
        attachedFiles: [
          {
            fileName: "기계설비신문(21.04.26).pdf",
            fileUrl: require("@/assets/pdf/기계설비신문(21.04.26).pdf")
          }
        ]
      }
    ]
  })
};
</script>
<style scoped></style>
