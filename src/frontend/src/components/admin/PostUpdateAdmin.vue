<template>
  <v-main>
    <div>
      <h2>
        <span style="color:red">{{ component.name }}</span> 수정하기
      </h2>
      <h5>
        * 첨부파일이 너무 크면 서버에 부담이갑니다ㅠ 파일당 1MB를 안넘었으면
        좋겠어요,.
      </h5>
      <v-text-field
        label="글 제목"
        :rules="rules"
        v-model="updatingPost.title"
        hide-details="auto"
      ></v-text-field>
      <v-textarea
        name="input-7-1"
        label="글 내용"
        :rules="rules"
        v-model="updatingPost.content"
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
    <v-btn outlined color="indigo" @click="requestUpdate" class="submit-btn">
      {{ component.name }} 수정 완료
    </v-btn>
    <v-btn outlined color="indigo" @click="close" class="submit-btn">
      닫기
    </v-btn>
  </v-main>
</template>
<script>
export default {
  props: ["component", "updatingPost"],
  data: () => ({
    uploadFiles: [],
    savedUploadFiles: [],
    rules: [value => !!value || "한 글자 이상은 작성해주세요ㅠ."]
  }),
  methods: {
    deleteFile(index) {
      this.uploadFiles = [];
      this.savedUploadFiles.splice(index, 1);
    },
    requestUpdate() {
      let formData = new FormData();
      this.savedUploadFiles.forEach(file => {
        formData.append("files", file);
        this.updatingPost.fileNames.push(file.name);
      });
      this.$axios
        .post("/files", formData)
        .catch(error => alert(error.response.data));
      this.$axios
        .post(this.component.uri, this.updatingPost) // 수정
        .catch(error => alert(error.response.data));
      this.close();
    },
    close() {
      this.$emit("close-update");
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
