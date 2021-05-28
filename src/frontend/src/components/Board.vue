<template>
  <div class="board-wrap">
    <v-data-table
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
</template>
<script>
export default {
  data: () => ({
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
};
</script>
<style scoped>
.board-wrap {
  margin-top: 1.5vw;
  margin-bottom: 1.5vw;
}
</style>
