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
          <v-list dark class="mobile-menu">
            <v-list-item
              v-for="(subMenu, index) in extractSubMenusForMobile()"
              :key="index"
            >
              <router-link :to="subMenu.path" tag="span">
                <v-list-item-title>{{ subMenu.title }}</v-list-item-title>
              </router-link>
            </v-list-item>
          </v-list>
        </v-menu>
        <!-- 모바일 메뉴 끝 -->
        <v-toolbar-items class="mx-auto text-center hidden-sm-and-down">
          <v-list class="menu-list" v-for="(menu, index) in menus" :key="index">
            <v-list-item-group>
              <v-list-item-content>
                <router-link :to="menu.path" tag="span">
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
          class="sub-menus hidden-sm-and-down"
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
                    <router-link :to="subMenu.path" tag="span">
                      <v-list-item-title
                        v-text="subMenu.title"
                        class="sub-menu-title"
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
    mobileTitles: [],
    menus: [
      {
        title: "제품소개",
        path: "/smart-go",
        subMenus: [
          {
            title: `스마트 고 유무선 분산시스템 솔루션`,
            path: "/smart-go"
          },
          {
            title: `뉴딜 고 원격관리 솔루션`,
            path: "/new-deal-go"
          },
          {
            title: `그린뉴딜 고 산업안전환경 솔루션`,
            path: "/green-new-deal-go"
          },
          {
            title: "제품 카다로그",
            path: "/product-catalog"
          }
        ]
      },
      {
        title: "고객지원",
        path: "/notice",
        subMenus: [
          {
            title: "공지사항",
            path: "/notice"
          },
          {
            title: "자료실",
            path: "/archive"
          }
        ]
      },
      {
        title: "회사소개",
        path: "/greeting",
        subMenus: [
          {
            title: "CEO 인사",
            path: "/greeting"
          },
          {
            title: "회사 연혁",
            path: "/history"
          },
          {
            title: "주요 실적",
            path: "/performance"
          },
          {
            title: "찾아오시는 길",
            path: "/contact"
          }
        ]
      },
      {
        title: "쇼핑몰",
        path: "/#"
      }
    ]
  }),
  methods: {
    extractSubMenusForMobile() {
      let menuTitles = [];
      this.menus.forEach(menu => {
        for (let i in menu.subMenus) {
          menuTitles.push(menu.subMenus[i]);
        }
      });
      return menuTitles;
    }
  }
};
</script>
<style scoped>
.menu-list {
  width: 15vw;
  background-color: transparent !important;
}

.main-title {
  color: #ffffff;
  font-weight: 500;
  font-size: 18px;
}

.sub-menus-wrap {
  margin-left: 18.3vw;
}

.sub-menus {
  height: 250px;
  width: 100%;
  opacity: 0.8;
  position: absolute;
  z-index: 5;
}

.sub-title-wrap {
  color: white;
  text-align: left;
}

.sub-menu-list {
  width: 15.1vw;
  background-color: transparent !important;
}

.sub-menu-title {
  white-space: normal;
  font-size: 0.9rem;
  margin-top: 15px;
}

span {
  cursor: pointer;
}

span:hover {
  color: #1a9a1a;
  font-weight: 900;
}

.mobile-menu {
  opacity: 0.9 !important;
}
</style>
