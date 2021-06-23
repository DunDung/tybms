<template>
  <v-main>
    <v-card rounded="0" class="wrap">
      <v-tabs background-color="#1A9A1A" center-active centered dark>
        <v-tab
          @click="handleAdmin(index)"
          v-for="(menu, index) in menus"
          :key="index"
          class="menu"
        >
          {{ menu.name }}
        </v-tab>
      </v-tabs>
    </v-card>
    <BoardAdmin :component="component" />

    <v-row justify="center">
      <v-dialog v-model="dialog" persistent overlay-opacity="1">
        <v-alert
                v-if="isWrongPassword"
                dense
                outlined
                type="error"
        >
          비밀번호가 틀렸습니다! {{wrongPasswordCount}}회
        </v-alert>
        <v-card class="password-wrap">
          <v-card-title class="text-h5 ma-auto">
            비밀번호를 입력해주세요!
          </v-card-title>
          <v-text-field
            class="password-input"
            v-model="password"
            :append-icon="isShowPassword ? 'mdi-eye' : 'mdi-eye-off'"
            :rules="[rules.required]"
            :type="isShowPassword ? 'text' : 'password'"
            name="input-10-1"
            label="비밀번호"
            @click:append="isShowPassword = !isShowPassword"
            @keyup.enter="requestMatchPassword"
          ></v-text-field>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="green darken-1" text @click="requestMatchPassword">
              완료
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </v-main>
</template>
<script>
import EventBus from "@/event-bus/EventBus.js";
import BoardAdmin from "@/components/admin/BoardAdmin";
export default {
  created() {
    EventBus.$emit("admin", true);
  },
  destroyed() {
    EventBus.$emit("admin", false);
  },
  components: {
    BoardAdmin
  },
  data: () => ({
    dialog: false,
    isShowPassword: false,
    password: "",
    isWrongPassword: false,
    wrongPasswordCount: 0,
    rules: {
      required: value => !!value || "Required."
    },
    menus: [
      {
        name: "공지사항",
        uri: "/notices"
      },
      {
        name: "자료실",
        uri: "/materials"
      },
      {
        name: "제품 카다로그",
        uri: "/products"
      },
      {
        name: "홈페이지로 돌아가기",
        uri: "/"
      }
    ],
    component: {
      name: "공지사항",
      uri: "/notices"
    }
  }),
  methods: {
    handleAdmin(index) {
      if (this.menus[index].name === "홈페이지로 돌아가기") {
        this.$router.push("/");
      }
      this.component = this.menus[index];
    },
    requestMatchPassword() {
      this.$axios
        .post("/passwords", { password: this.password })
        .then(res => {
          if (res.data === true) {
            this.dialog = false;
          } else {
            this.isWrongPassword = true;
            this.wrongPasswordCount++;
          }
        })
        .catch(error => alert(error.response.data));
    }
  }
};
</script>
<style scoped>
.wrap {
  margin-bottom: 1vw;
}
.menu {
  width: 20%;
}
.password-input {
  margin: 10px;
}
.password-wrap {
  display: flex;
  justify-items: center;
  flex-direction: column;
  margin: 0 auto;
}

.v-card__title {
  font-family: "Nanum Gothic", sans-serif !important;
  font-weight: bold !important;
}
</style>
