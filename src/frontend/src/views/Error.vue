<template>
  <v-main class="main-wrap">
    <v-container class="sub-wrap">
      <h1>404</h1>
      <h2>죄송합니다. 현재 찾을 수 없는 페이지를 요청하셨습니다.</h2>
      <h4>존재하지 않는 주소를 입력하셨거나,</h4>
      <h4>요청하신 페이지의 주소가 변경, 삭제되어 찾을 수 없습니다.</h4>
      <h4>
        궁금한 점이 있으시면 <strong>hakim@tybms.co.kr</strong> 메일을 통해
        문의해 주시기 바랍니다.
      </h4>
      <h4>감사합니다.☺️</h4>
      <v-container class="buttons">
        <v-btn text outlined to="/" class="error-btn"
          >메인으로</v-btn
        >
        <v-btn text outlined @click="$router.go(-1)" class="error-btn"
          >이전 페이지</v-btn
        >
      </v-container>
    </v-container>
  </v-main>
</template>
<script>
export default {
};
</script>
<style scoped>
.main-wrap {
  font-family: "NanumSquare", sans-serif !important;
}
.sub-wrap {
  display: flex;
  flex-direction: column;
  align-items: center;
}
h1 {
  font-family: "Do Hyeon", sans-serif;
  font-size: 150px;
  color: green;
  letter-spacing: 10px;
}
h2 {
  font-size: 35px;
}
h4 {
  font-size: 20px;
  margin-top: 10px;
}
.error-btn {
  border-color: black !important;
  font-family: "NanumSquare", sans-serif !important;
  font-weight: bold;
  font-size: 20px;
  margin: 0 10px 0 10px
}
.buttons {
  display: flex;
  flex-direction: row;
  justify-content: center;
}
</style>
