<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <v-main class="flex">
    <v-container class="text-right">
      <v-btn
        width="30%"
        color="blue-grey"
        class="ma-2 white--text"
        @click="onClickCreateButton"
        >{{ component.name }} 작성하기</v-btn
      >
    </v-container>
    <PostCreateAdmin
      :component="component"
      v-if="isCreate"
      @close-create="closeCreate"
    />
    <PostUpdateAdmin
      :component="component"
      v-if="isUpdate"
      :updatingPost="clickedPost"
      @close-update="closeUpdate"
    />
    <div>
      <h2>
        <span style="color:red">{{ component.name }}</span> 수정 / 삭제하기
      </h2>
      <h5>* 글 클릭하면 삭제/수정 메뉴 뜹니다 :)</h5>
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
                <v-btn text @click="onClickUpdate">
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
import PostCreateAdmin from "@/components/admin/PostCreateAdmin";
import PostUpdateAdmin from "@/components/admin/PostUpdateAdmin";
export default {
  components: {
    PostCreateAdmin,
    PostUpdateAdmin
  },
  props: ["component"],
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
      // props
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
    dialog: false,
    isCreate: false,
    isUpdate: false
  }),
  methods: {
    openDeleteOrUpdateModal(clickedPost) {
      this.clickedPost = clickedPost;
      this.dialog = true;
    },
    onClickCreateButton() {
      this.isCreate = true;
    },
    onClickUpdate() {
      this.isUpdate = true;
      this.dialog = false;
    },
    closeCreate() {
      this.isCreate = false;
    },
    closeUpdate() {
      this.isUpdate = false;
    }
  }
};
</script>
<style scoped>
.v-card {
  display: flex;
}
</style>
