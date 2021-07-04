<template>
  <v-main>
    <div>
      <h2>
        <span style="color:red">{{ component.name }}</span> 수정하기
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
        v-model="updatingPost.title"
        hide-details="auto"
      ></v-text-field>
      <v-textarea
        name="input-7-1"
        label="글 내용"
        :rules="rules"
        v-model="updatingPost.content"
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
        <h4><strong style="color: red">추가 </strong> 첨부된 파일 목록 :</h4>
        <v-chip
          v-for="(file, index) in getSavedUploadFiles"
          :key="index"
          class="ma-2"
          close
          color="red"
          text-color="white"
          @click:close="deleteNewFile(index)"
        >
          {{ file.name }}
        </v-chip>
      </div>
      <div v-if="isNotProductCatalog()" style="margin-top : 20px">
        <h4><strong style="color: red">기존에</strong> 첨부된 파일 목록 :</h4>
        <v-chip
          v-for="(fileName, index) in updatingPost.fileNames"
          :key="index"
          class="ma-2"
          close
          color="red"
          text-color="white"
          @click:close="deleteAgoFile(index)"
        >
          {{ fileName }}
        </v-chip>
      </div>
      <div v-if="!isNotProductCatalog()" style="margin-top : 20px">
        <h4><strong style="color: red">기존에</strong> 첨부된 파일 :</h4>
        <v-chip class="ma-2" color="red" text-color="white">
          {{ updatingPost.attachedFile }}
        </v-chip>
      </div>
      <div v-if="isNotProductCatalog()">
        <h5 style="margin-top : 20px">
          * (추가 첨부된 파일 목록 + 기존에 첨부된 파일 목록) = 최종 파일 목록
        </h5>
        <h5>
          * 추가 첨부된 파일 목록과 기존에 첨부된 파일 목록이 더해진 파일
          목록으로 최종 수정됩니다.
        </h5>
      </div>
      <div v-if="!isNotProductCatalog()">
        <h5>
          * 제품 카다로그 첨부 파일은 하나만 가능하기 때문에 새로 파일을
          첨부하면 기존의 첨부된 파일이 덮어씌워집니다!
        </h5>
      </div>
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
    deleteNewFile(index) {
      this.notProductUploadFiles = [];
      this.savedUploadFiles.splice(index, 1);
    },
    deleteAgoFile(index) {
      this.updatingPost.fileNames.splice(index, 1);
    },
    requestUpdate() {
      let formData = new FormData();
      if (this.isNotProductCatalog()) {
        this.savedUploadFiles.forEach(file => {
          formData.append("files", file);
          this.updatingPost.fileNames.push(file.name);
        });
      } else {
        if (this.productUploadFile != null) {
          formData.append("files", this.productUploadFile);
          this.updatingPost.attachedFile = this.productUploadFile.name;
        }
      }
      this.$axios
        .post("/files", formData, {
          timeout: 100000
        })
        .catch(error => alert(error.response.data));
      this.$axios
        .put(this.component.uri, this.updatingPost)
        .catch(error => alert(error.response.data));
      this.$router.go();
    },
    close() {
      this.$emit("close-update");
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
