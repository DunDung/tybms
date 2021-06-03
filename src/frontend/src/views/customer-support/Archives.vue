<template>
  <v-main>
    <ImageFrame :frame="frame" />
    <Board :posts="posts" />
  </v-main>
</template>
<script>
import ImageFrame from "@/components/detail/ImageFrame";
import Board from "@/components/detail/Board";

export default {
  components: {
    ImageFrame,
    Board
  },
  data: () => ({
    frame: {
      content: "자료실",
      subContent: `고객지원   >   자료실`,
      backgroundImageUrls: {
        w640: require("@/assets/images/frame/customer-support/archives-640.png"),
        w960: require("@/assets/images/frame/customer-support/archives-960.png"),
        w1280: require("@/assets/images/frame/customer-support/archives-1280.png"),
        w1920: require("@/assets/images/frame/customer-support/archives-1920.png")
      }
    },
    posts: [
      {
        id: 1,
        title: "제 1기 주주총회 안내문 ",
        updatedDate: "2021.05.13",
        views: 24
      },
      {
        id: 2,
        title: "제 2기 주주총회 안내문 ",
        updatedDate: "2021.05.14",
        views: 21
      },
      {
        id: 3,
        title: "제 3기 주주총회 안내문 ",
        updatedDate: "2021.05.15",
        views: 25
      },
      {
        id: 4,
        title: "제 4기 주주총회 안내문 ",
        updatedDate: "2021.05.16",
        views: 27
      },
      {
        id: 5,
        title: "제 5기 주주총회 안내문 ",
        updatedDate: "2021.05.17",
        views: 2
      },
      {
        id: 6,
        title: "제 6기 주주총회 안내문 ",
        updatedDate: "2021.05.18",
        views: 27
      },
      {
        id: 7,
        title: "제 7기 주주총회 안내문 ",
        updatedDate: "2021.05.19",
        views: 27
      },
      {
        id: 8,
        title: "제 8기 주주총회 안내문 ",
        updatedDate: "2021.05.20",
        views: 7
      },
      {
        id: 9,
        title: "제 9기 주주총회 안내문 ",
        updatedDate: "2021.05.21",
        views: 2
      },
      {
        id: 10,
        title: "제 10기 주주총회 안내문 ",
        updatedDate: "2021.05.28",
        views: 27
      },
      {
        id: 11,
        title: "제 11기 주주총회 안내문 ",
        updatedDate: "2021.05.29",
        views: 87
      }
    ]
  })
};
</script>
<style scoped></style>
