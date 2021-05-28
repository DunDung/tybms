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
    ImageFrame, Board
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
    },
    posts: [
      {
        id: 1,
        title: "공지사항 1" ,
        updatedDate: "2021.05.13",
        views: 24
      },
      {
        id: 2,
        title: "공지사항 2",
        updatedDate: "2021.05.14",
        views: 21
      },
      {
        id: 3,
        title: "공지사항 3",
        updatedDate: "2021.05.15",
        views: 25
      },
      {
        id: 4,
        title: "공지사항 4",
        updatedDate: "2021.05.16",
        views: 27
      },
      {
        id: 5,
        title: "공지사항 5",
        updatedDate: "2021.05.17",
        views: 2
      },
      {
        id: 6,
        title: "공지사항 6",
        updatedDate: "2021.05.18",
        views: 27
      },
      {
        id: 7,
        title: "공지사항 7",
        updatedDate: "2021.05.19",
        views: 27
      },
      {
        id: 8,
        title: "공지사항 8",
        updatedDate: "2021.05.20",
        views: 7
      },
      {
        id: 9,
        title: "공지사항 9",
        updatedDate: "2021.05.21",
        views: 2
      },
      {
        id: 10,
        title: "공지사항 10",
        updatedDate: "2021.05.28",
        views: 27
      },
      {
        id: 11,
        title: "공지사항 11",
        updatedDate: "2021.05.29",
        views: 87
      }
    ]

  }),

};
</script>
<style scoped></style>
