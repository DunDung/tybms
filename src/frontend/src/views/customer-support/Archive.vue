<template>
  <v-main>
    <ImageFrame :frame="frame" />
    <DetailPost
      v-if="isViewDetailPost"
      :clickedPost="clickedPost"
    />
    <Board :posts="getMaterials" />
  </v-main>
</template>
<script>
import ImageFrame from "@/components/detail/ImageFrame";
import Board from "@/components/detail/Board";
import DetailPost from "@/components/detail/DetailPost";
import { mapGetters, mapMutations } from "vuex";

export default {
  components: {
    ImageFrame,
    Board,
    DetailPost
  },
  computed: {
    ...mapGetters(["getMaterials"])
  },
  created() {
    this.showDetailPost(this.$route.params.id);
  },
  watch: {
    $route() {
      this.showDetailPost(this.$route.params.id);
    }
  },
  methods: {
    showDetailPost(id) {
      if (id) {
        const index = this.getMaterials.findIndex(
          material => material.id == id
        );
        this.clickedPost = this.getMaterials[index];
        this.isViewDetailPost = true;
        this.SET_MATERIAL_VIEW_COUNTS({ id: id, index: index });
      } else {
        this.isViewDetailPost = false;
      }
    },
    ...mapMutations(["SET_MATERIAL_VIEW_COUNTS"])
  },
  data: () => ({
    isViewDetailPost: false,
    clickedPost: {},
    frame: {
      content: "자료실",
      subContent: `고객지원   >   자료실`,
      backgroundImageUrls: {
        w640: require("@/assets/images/frame/customer-support/archive-640.png"),
        w960: require("@/assets/images/frame/customer-support/archive-960.png"),
        w1280: require("@/assets/images/frame/customer-support/archive-1280.png"),
        w1920: require("@/assets/images/frame/customer-support/archive-1920.png")
      }
    }
  })
};
</script>
<style scoped></style>
