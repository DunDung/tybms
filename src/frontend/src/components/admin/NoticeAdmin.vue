<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <v-main class="flex">
    <div class="text-right">
      <span>글 클릭하면 삭제/수정 메뉴 뜹니다 :)</span>
      <v-btn class="ma-2" outlined color="indigo">
        글 쓰기
      </v-btn>
    </div>
    <NoticeCreateAdmin />
    <div>
      <v-data-table
        @click:row="openDeleteOrUpdateModal"
        :headers="headers"
        :items="posts"
        :page.sync="page"
        :items-per-page="itemsPerPage"
        :sort-by="['id']"
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
      <v-dialog v-model="dialog">
        <v-card class="flex flex-column justify-center">
          <v-card-title class="text-h5 ma-auto">
            {{ clickedPost.title }}
          </v-card-title>
          <table class="ma-auto">
            <tr>
              <td>
                <v-btn text @click="dialog = false">
                  삭제
                </v-btn>
              </td>
              <td>
                <v-btn text @click="dialog = false">
                  수정
                </v-btn>
              </td>
              <td>
                <v-btn text @click="dialog = false">
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
import NoticeCreateAdmin from "@/components/admin/NoticeCreateAdmin";
export default {
  components: {
    NoticeCreateAdmin
  },
  data: () => ({
    page: 1,
    pageCount: 0,
    itemsPerPage: 30,
    headers: [
      {
        text: "번호",
        align: "center",
        sortable: false,
        value: "id"
      },
      { text: "제목", sortable: false, value: "title" }
    ],
    posts: [
      {
        id: 1,
        title: "1번 글"
      },
      {
        id: 2,
        title: "2번 글"
      }
    ],
    clickedPost: {},
    dialog: false
  }),
  methods: {
    openDeleteOrUpdateModal(clickedPost) {
      this.clickedPost = clickedPost;
      this.dialog = true;
    }
  }
};
</script>
<style scoped>
.v-card {
  display: flex;
}
</style>
