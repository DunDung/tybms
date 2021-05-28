<template>
  <v-footer padless>
    <v-container class="footer-container">
      <div class="wrap">
        <span
          class="content-wrap"
          v-for="(topRow, index) in topRows"
          :key="index"
        >
          <span class="footer-title">{{ topRow.title }}</span>
          <span class="footer-content">{{ topRow.content }}</span>
        </span>
      </div>
      <div class="wrap">
        <span
          class="content-wrap"
          v-for="(bottomRow, index) in bottomRows"
          :key="index"
        >
          <span class="footer-title">{{ bottomRow.title }}</span>
          <span class="footer-content">{{ bottomRow.content }}</span>
        </span>
      </div>
      <small class="footer__copyright">
        &copy; 2021 동양BMS㈜. ALL RIGHTS RESERVED.
      </small>
    </v-container>
  </v-footer>
</template>
<script>
export default {
  data: () => ({
    topRows: [
      {
        title: "법인명(상호)",
        content: "동양BMS㈜"
      },
      {
        title: "대표자",
        content: "김태수"
      },
      {
        title: "사업자 등록번호 안내",
        content: "[212-81-44463]"
      }
    ],
    bottomRows: [
      {
        title: "대표번호",
        content: "02-6347-8330"
      },
      {
        title: "팩스번호",
        content: "02-6347-8336"
      },
      {
        title: "주소",
        content: "서울시 구로구 디지털로 285, 701호(에이스트윈타워 1차)"
      }
    ]
  })
};
</script>
<style scoped>
.footer-container {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}
.wrap {
  margin-bottom: 5px;
}
.content-wrap {
  margin-left: 30px;
  margin-right: 30px;
}
.footer-title {
  margin-right: 2.5px;
  color: gray;
  font-size: 12px;
}
.footer-content {
  margin-left: 2.5px;
  font-size: 14px;
}

.footer__copyright {
  font-size: 14px;
  margin-top: 5px;
}
@media screen and (max-width: 960px) {
  .footer-container {
  }
  .wrap {
    display: flex;
    justify-content: flex-start;
    flex-direction: column;
    width: 100%;
  }
  .content-wrap {
    margin-left: 0;
  }
  .footer__copyright {
    width: 100%;
    justify-content: flex-start;
  }
}
</style>
