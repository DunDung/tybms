<template>
  <v-main class="wrap">
    <v-card>
      <header>
        <table width="100%" color="gray" class="header">
          <tr>
            <td width="50%" align="left">
              <span class="header-title"
                ><strong>{{ clickedPost.title }}</strong></span
              >
            </td>
            <td width="30%" align="right">
              <span class="header-sub-title"
                ><strong>최종 수정</strong> {{ clickedPost.modifiedDate }}</span
              >
            </td>
            <td width="15%" align="center">
              <span class="header-sub-title"
                ><strong>조회 수</strong> {{ clickedPost.viewCount }}</span
              >
            </td>
          </tr>
        </table>
      </header>
      <div class="content">
        {{ clickedPost.content }}
      </div>
      <hr />
      <div class="attached-file">
        <strong>첨부 파일</strong>
        <ol>
          <small>
            <li v-for="(attachedFile, i) in clickedPost.attachedFiles" :key="i">
              <a :download="attachedFile.fileName" :href="attachedFile.fileUrl"
                >{{ attachedFile.fileName }}
              </a>
            </li>
          </small>
        </ol>
      </div>
    </v-card>
  </v-main>
</template>
<script>
export default {
  props: ["clickedPost", "requestUri"],
  created() {},
  data: () => ({})
};
</script>
<style scoped>
.wrap {
  margin-top: 1.5vw;
  margin-bottom: 1.5vw;
}
.header {
  background-color: rgb(240, 240, 240);
  padding: 10px;
}
.header-title {
  font-size: 1.8vw;
}
.header-sub-title {
  font-size: 0.8vw;
}

.content,
.attached-file {
  font-size: 1vw;
  padding: 10px;
  white-space: pre-line;
  line-height: 1.7;
}
</style>
