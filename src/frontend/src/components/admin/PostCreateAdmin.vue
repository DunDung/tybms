<template>
  <v-main>
    <div>
      <h2>
        <span style="color:red">{{ component.name }}</span> 작성하기
      </h2>
      <h5>
        * PDF 파일만 업로드되게 만들어놨어요. 다른 파일 형식도 필요하시면 편하게
        말씀해주세용
      </h5>
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
        v-show="isNotProductCatalog()"
        auto-grow
      ></v-textarea>
      <v-file-input
        multiple
        label="파일 입력"
        show-size
        v-model="uploadFiles"
      ></v-file-input>
      <h4>첨부된 파일 목록 :</h4>
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
    <v-btn outlined color="indigo" @click="requestCreate" class="submit-btn">
      {{ component.name }} 작성 완료
    </v-btn>
    <v-btn outlined color="indigo" @click="close" class="submit-btn">
      닫기
    </v-btn>
  </v-main>
</template>
<script>
export default {
  props: ["component"],
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
    requestCreate() {
      let formData = new FormData();
      this.savedUploadFiles.forEach(file => {
        formData.append("files", file);
        this.creatingPost.fileNames.push(file.name);
      });
      this.$axios
        .post("/files", formData)
        .catch(error => alert(error.response.data));
      this.$axios
        .post(this.component.uri, this.creatingPost)
        .catch(error => alert(error.response.data));
      this.$router.go(); // 새로고침
      this.close();
    },
    close() {
      this.$emit("close-create");
    },
    isNotProductCatalog() {
      return this.component.name !== "제품 카다로그";
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
<style scoped>
.submit-btn {
  margin-bottom: 1vw;
  margin-right: 20px;
  margin-top: 1vw;
}
</style>
