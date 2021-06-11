<template>
  <v-main>
    <div>
      <h2>글 작성하기</h2>
      <h5>
        * 첨부파일이 너무 크면 서버에 부담이갑니다ㅠ 파일당 1MB를 안넘었으면
        좋겠어요,.
      </h5>
      <v-text-field
        label="글 제목"
        :rules="rules"
        v-model="creatingPost.title"
        hide-details="auto"
      ></v-text-field>
      <v-textarea
        name="input-7-1"
        label="글 내용"
        :rules="rules"
        v-model="creatingPost.content"
        auto-grow
      ></v-textarea>
      <v-file-input
        multiple
        label="파일 입력"
        show-size
        v-model="uploadFiles"
      ></v-file-input>
      <label style="color:gray">첨부된 파일 목록</label>
      <v-chip
        v-for="(file, index) in getSavedUploadFiles"
        :key="index"
        class="ma-2"
        close
        color="red"
        text-color="white"
        @click:close="deleteFile(index)"
      >
        {{ file.name }}
      </v-chip>
    </div>
    <v-btn class="ma-2" outlined color="indigo" @click="request">
      완료
    </v-btn>
  </v-main>
</template>
<script>
export default {
  data: () => ({
    creatingPost: {
      title: "",
      content: ``,
      fileNames: []
    },
    uploadFiles: [],
    savedUploadFiles: [],
    rules: [value => !!value || "한 글자 이상은 작성해주세요ㅠ."]
  }),
  methods: {
    deleteFile(index) {
      this.uploadFiles = [];
      this.savedUploadFiles.splice(index, 1);
    },
    request() {
      let formData = new FormData();
      this.savedUploadFiles.forEach(file => {
        formData.append("files", file);
        this.creatingPost.fileNames.push(file.name);
      });
      this.$axios
        .post("/files", formData)
        .catch(error => alert(error.response.data));
      this.$axios
        .post("/notices", this.creatingPost)
        .catch(error => alert(error.response.data));
    }
  },
  computed: {
    getSavedUploadFiles() {
      this.uploadFiles.forEach(file => this.savedUploadFiles.push(file));
      return this.savedUploadFiles;
    }
  }
};
</script>
