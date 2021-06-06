<template>
  <v-container class="flex justify-center">
    <v-dialog v-model="dialog" max-width="25%">
      <v-card class="modal-wrap">
        <v-card-title class="text-h5 ma-auto">
          {{ product.title }}
        </v-card-title>
        <table class="ma-auto">
          <tr>
            <td>
              <v-btn
                text
                :href="product.fileUrl"
                :download="product.title"
                @click="$emit('close')"
                style="font-weight: bold"
              >
                다운로드
              </v-btn>
            </td>
            <td>
              <v-btn
                text
                @click="$emit('close')"
                :href="product.fileUrl"
                style="font-weight: bold"
                target="_blank"
              >
                열기
              </v-btn>
            </td>
            <td>
              <v-btn text @click="$emit('close')" style="font-weight: bold">
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
  })
};
</script>

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

.v-btn {
  width: 100%;
  font-size: 1rem;
  letter-spacing: 0.2rem;
}

.container {
  padding: 0px !important;
}
</style>
