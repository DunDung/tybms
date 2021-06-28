<template>
  <v-main>
    <div class="board-wrap">
      <v-data-table
        @click:row="openProductModal"
        :headers="headers"
        :items="products"
        :page.sync="page"
        :items-per-page="itemsPerPage"
        :sort-by="['updatedDate']"
        :sort-desc="[true]"
        hide-default-footer
        class="elevation-1"
        @page-count="pageCount = $event"
      >
      </v-data-table>
      <div class="text-center pt-2 mt-4">
        <v-pagination v-model="page" :length="pageCount"></v-pagination>
      </div>
    </div>
    <ProductModal
      v-if="isShow"
      :product="clickedPost"
      @close="isShow = false"
    />
  </v-main>
</template>
<script>
import ProductModal from "@/components/detail/ProductModal";
import { mapMutations } from "vuex";

export default {
  data: () => ({
    isShow: false,
    clickedPost: {},
    page: 1,
    pageCount: 0,
    itemsPerPage: 10,
    headers: [
      {
        text: "번호",
        align: "center",
        sortable: false,
        value: "id"
      },
      { text: "제목", sortable: false, value: "title" },
      { text: "날짜", sortable: false, align: "center", value: "modifiedDate" },
      { text: "조회 수", sortable: false, align: "center", value: "viewCount" }
    ]
  }),
  props: ["products"],
  components: {
    ProductModal
  },
  methods: {
    openProductModal(clickedPost) {
      const index = this.products.findIndex(product => product.id == clickedPost.id);
      this.SET_PRODUCT_VIEW_COUNTS({ id: clickedPost.id, index: index });
      this.clickedPost = clickedPost;
      this.isShow = true;
    },
    ...mapMutations(["SET_PRODUCT_VIEW_COUNTS"])
  }
};
</script>
<style scoped>
.board-wrap {
  margin-top: 1.5vw;
  margin-bottom: 1.5vw;
}
</style>
