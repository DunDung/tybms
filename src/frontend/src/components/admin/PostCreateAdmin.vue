<template>
  <v-main>
    <div>
      <h2>
        <span style="color:red">{{ component.name }}</span> 작성하기
      </h2>
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
          v-if="isNotProductCatalog()"
          v-model="notProductUploadFiles"
      ></v-file-input>
      <v-file-input
          label="파일 입력, 하나만 가능"
          show-size
          v-if="!isNotProductCatalog()"
          v-model="productUploadFile"
      ></v-file-input>
      <div v-if="isNotProductCatalog()">
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
    notProductUploadFiles: [],
    productUploadFile: null,
    savedUploadFiles: [],
    rules: [value => !!value || "한 글자 이상은 작성해주세요ㅠ."]
  }),
  computed: {
    getSavedUploadFiles() {
      this.notProductUploadFiles.forEach(file =>
          this.savedUploadFiles.push(file)
      );
      return this.savedUploadFiles;
    }
  },
  methods: {
    deleteFile(index) {
      this.notProductUploadFiles = [];
      this.savedUploadFiles.splice(index, 1);
    },
    async requestCreate() {
      if (this.creatingPost.title === "") {
        alert("제목은 비어있을 수 없습니다!");
        return;
      }
      let formData = new FormData();
      if (this.isNotProductCatalog()) {
        this.savedUploadFiles.forEach(file => {
          formData.append("files", file);
          this.creatingPost.fileNames.push(file.name);
        });
      } else {
        if (this.productUploadFile == null) {
          alert("제품 카다로그 파일은 비어있을 수 없습니다!");
          return;
        }
        formData.append("files", this.productUploadFile);
        this.creatingPost.attachedFile = this.productUploadFile.name;
      }
      this.$axios
          .post(this.component.uri, this.creatingPost)
          .catch(error => alert(error.response.data));
      await this.$axios
          .post("/files", formData, {
            timeout: 600000
          })
          .catch(error => alert(error.response.data));
      this.$router.go();
    },
    close() {
      this.$emit("close-create");
    },
    isNotProductCatalog() {
      return this.component.name !== "제품 카다로그";
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
