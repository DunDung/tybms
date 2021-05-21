<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <v-hover v-slot="{ hover }">
    <v-card rounded="0">
      <v-toolbar color="#1A9A1A">
        <router-link to="/" style="margin-left: -5px">
          <v-img src="@/assets/images/header/logo.png" />
        </router-link>


        <!-- 모바일 메뉴 -->
        <v-spacer class="hidden-md-and-up"></v-spacer>
        <v-menu offset-y>
          <template v-slot:activator="{ on, attrs }">
            <v-app-bar-nav-icon
              v-bind="attrs"
              v-on="on"
              class="hidden-md-and-up"
            >
            </v-app-bar-nav-icon>
          </template>
            <v-list>
              <v-list-item v-for="(menu, index) in menus" :key="index">
                <v-list-item-title>{{ menu.title }}</v-list-item-title>
              </v-list-item>
            </v-list>
        </v-menu>

        <v-toolbar-items class="mx-auto text-center hidden-sm-and-down">
          <v-list class="menu-list" v-for="(menu, index) in menus" :key="index">
            <v-list-item-group>
              <v-list-item-content>
                <router-link to="/#" tag="span">
                  <v-list-item-title class="main-title" v-text="menu.title" />
                </router-link>
              </v-list-item-content>
            </v-list-item-group>
          </v-list>
        </v-toolbar-items>
      </v-toolbar>
      <v-expand-transition>
        <v-card
          rounded="0"
          v-if="hover"
          color="black"
          class="sub-menus v-navigation-drawer--absolute hidden-sm-and-down"
        >
          <v-toolbar color="transparent" class="sub-menus-wrap">
            <v-toolbar-items>
              <v-list
                class="sub-menu-list"
                v-for="(menu, index) in menus"
                :key="index"
              >
                <v-list-item-group>
                  <v-list-item-content
                    class="sub-title-wrap"
                    v-for="(subMenu, index) in menu.subMenus"
                    :key="index"
                  >
                    <router-link to="/#" tag="span">
                      <v-list-item-title
                        v-text="subMenu.title"
                        class="sub-menu-title"
                      />
                    </router-link>
                    <router-link
                      to="/#"
                      tag="span"
                      v-for="(deepSubMenu, index) in subMenu.deepSubMenus"
                      :key="index"
                    >
                      <v-list-item-title
                        v-text="deepSubMenu.title"
                        class="deep-sub-menu-title"
                      />
                    </router-link>
                  </v-list-item-content>
                </v-list-item-group>
              </v-list>
            </v-toolbar-items>
          </v-toolbar>
        </v-card>
      </v-expand-transition>
    </v-card>
  </v-hover>
</template>
<script>
export default {
  data: () => ({
    menus: [
      {
        title: "제품소개",
        subMenus: [
          {
            title: "빌딩자동화 Solution",
            deepSubMenus: [
              {
                title: "설비자동제어 시스템"
              },
              {
                title: "전력감시 시스템"
              },
              {
                title: "조명제어 시스템"
              }
            ]
          },
          {
            title: "그린뉴딜 Solution",
            deepSubMenus: [
              {
                title: "Smart 환경 Solution"
              },
              {
                title: "IoT 유,무선 Solution"
              },
              {
                title: "멀티 통합 Solution"
              }
            ]
          },
          {
            title: "고객만족 Solution",
            deepSubMenus: [
              {
                title: "개보수공사 Solution"
              },
              {
                title: "유지보수 Solution"
              }
            ]
          },
          {
            title: "제품 Specification"
          }
        ]
      },
      {
        title: "고객지원",
        subMenus: [
          {
            title: "공지사항"
          },
          {
            title: "자료실"
          }
        ]
      },
      {
        title: "회사소개",
        subMenus: [
          {
            title: "CEO 인사"
          },
          {
            title: "회사 연혁"
          },
          {
            title: "주요 실적"
          },
          {
            title: "찾아오시는 길"
          }
        ]
      },
      {
        title: "쇼핑몰"
      }
    ]
  })
};
</script>
<style scoped>
.menu-list {
  width: 20vw;
  background-color: transparent !important;
}

.main-title {
  color: #ffffff;
  font-weight: 500;
  font-size: 20px;
}

.sub-menus {
  height: 53vh;
  width: 100%;
  opacity: 0.7;
}

.sub-menus-wrap {
  margin-left: 20.5vw;
}

.sub-title-wrap {
  color: white;
  text-align: left;
}

.sub-menu-list {
  width: 20.2vw;
  background-color: transparent !important;
}

.sub-menu-title {
  font-size: 1.1rem;
}

.deep-sub-menu-title {
  font-size: 0.8rem;
  margin-top: 1.3vh;
}

span {
  cursor: pointer;
}

span:hover {
  color: #1a9a1a;
  font-weight: 900;
}
</style>
