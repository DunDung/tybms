<template>
  <v-main>
    <div class="board-wrap">
      <v-data-table
        @click:row="openProductModal"
        :headers="headers"
        :items="posts"
        :page.sync="page"
        :items-per-page="itemsPerPage"
        :sort-by="['updatedDate']"
        :sort-desc="[true]"
        hide-default-footer
        class="elevation-1"
        @page-count="pageCount = $event"
      ></v-data-table>
      <div class="text-center pt-2 mt-4">
        <v-pagination v-model="page" :length="pageCount"></v-pagination>
      </div>
    </div>

    <v-container class="flex justify-center">
      <v-dialog v-model="dialog" max-width="25%">
        <v-card class="modal-wrap">
          <v-card-title class="text-h5 ma-auto">
            {{ clickedPost.title }}
          </v-card-title>
          <table class="ma-auto">
            <tr>
              <td>
                <v-btn
                  text
                  :href="clickedPost.fileUrl"
                  :download="clickedPost.title"
                  @click="dialog = false"
                  style="font-weight: bold"
                >
                  다운로드
                </v-btn>
              </td>
              <td>
                <v-btn
                  text
                  @click="dialog = false"
                  :href="clickedPost.fileUrl"
                  style="font-weight: bold"
                  target="_blank"
                >
                  열기
                </v-btn>
              </td>
              <td>
                <v-btn text @click="dialog = false" style="font-weight: bold">
                  닫기
                </v-btn>
              </td>
            </tr>
          </table>
        </v-card>
      </v-dialog>
    </v-container>
  </v-main>
</template>
<script>
export default {
  data: () => ({
    dialog: false,
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
      { text: "날짜", sortable: false, align: "center", value: "updatedDate" },
      { text: "조회 수", sortable: false, align: "center", value: "views" }
    ]
  }),
  props: ["posts"],
  methods: {
    openProductModal(clickedPost) {
      this.dialog = true;
      this.clickedPost = clickedPost;
    }
  }
};
</script>
<style scoped>
.board-wrap {
  margin-top: 1.5vw;
  margin-bottom: 1.5vw;
}

.modal-wrap {
  display: flex;
  justify-items: center;
  flex-direction: column;
  padding: 8px;
  margin: 0 auto;
}

td {
  width: 31%;
  text-align: center;
}

.v-btn {
  width: 100%;
  font-size: 1rem;
  letter-spacing: 0.2rem;
}
</style>
