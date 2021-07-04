<template>
  <v-container class="flex justify-center">
    <v-dialog v-model="dialog">
      <v-card class="modal-wrap">
        <v-card-title class="text-h5 ma-auto">
          {{ product.title }}
        </v-card-title>
        <table class="ma-auto">
          <tr>
            <td>
              <v-btn
                text
                :href="makeFileUrl(product)"
                :download="product.fileName"
                @click="$emit('close')"
              >
                다운로드
              </v-btn>
            </td>
            <td>
              <v-btn
                text
                @click="$emit('close')"
                :href="makeFileUrl(product)"
                target="_blank"
              >
                열기
              </v-btn>
            </td>
            <td>
              <v-btn text @click="$emit('close')">
                닫기
              </v-btn>
            </td>
          </tr>
        </table>
      </v-card>
    </v-dialog>
  </v-container>
</template>
<script>
export default {
  props: ["product"],
  data: () => ({
    dialog: true
  }),
  methods: {
    makeFileUrl(product) {
      return "/files/" + product.fileName;
    }
  }
};
</script>

<!--vuetify 사용 시 style을 전체 범위로 먹이지 않으면 element style을 바꿀 수 없음-->
<style>
.v-dialog {
  max-width: 30%;
}
@media screen and (max-width: 960px) {
  .v-dialog {
    max-width: 100% !important;
  }
}
</style>
<style scoped>
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

.v-card__title {
  font-family: "Nanum Gothic", sans-serif !important;
  font-weight: bold !important;
}

.v-btn {
  width: 100%;
  font-size: 1rem;
  letter-spacing: 0.2rem;
  font-weight: bold;
}

.container {
  padding: 0px !important;
}
</style>
