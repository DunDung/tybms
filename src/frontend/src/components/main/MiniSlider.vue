<template>
  <v-card elevation="0" rounded="0" class="cards">
    <v-carousel cycle hide-delimiter-background interval="3000" height="100%">
      <v-carousel-item v-for="(slide, i) in slides" :key="i">
        <v-row
          class="fill-height"
          align="center"
          justify="center"
          @click="openProductModal(slide)"
        >
          <picture>
            <source :srcset="slide.w320" media="(max-width: 400px)" />
            <source :srcset="slide.w640" media="(max-width: 640px)" />
            <source :srcset="slide.w960" media="(max-width: 960px)" />
            <source :srcset="slide.w320" media="(max-width: 1920px)" />
            <img :src="slide.w320" />
          </picture>
        </v-row>
      </v-carousel-item>
    </v-carousel>
    <ProductModal v-if="isShow" :product="product" @close="isShow = false" />
  </v-card>
</template>
<script>
import ProductModal from "@/components/detail/ProductModal";

export default {
  components: {
    ProductModal
  },
  methods: {
    openProductModal(slide) {
      this.isShow = true;
      this.product = slide.product;
    }
  },
  data: () => ({
    isShow: false,
    product: {},
    slides: [
      {
        w320: require("@/assets/images/main/mini-slider/mini-slider-1-320.png"),
        w640: require("@/assets/images/main/mini-slider/mini-slider-1-640.png"),
        w960: require("@/assets/images/main/mini-slider/mini-slider-1-960.png"),
        product: {
          title: "AQS Series CATALOG",
          fileUrl: require("@/assets/pdf/AQS-Series-CATALOG.pdf")
        }
      },
      {
        w320: require("@/assets/images/main/mini-slider/mini-slider-2-320.png"),
        w640: require("@/assets/images/main/mini-slider/mini-slider-2-640.png"),
        w960: require("@/assets/images/main/mini-slider/mini-slider-2-960.png"),
        product: {
          title: "스마트 산업 환경 알리미",
          fileUrl: ""
        }
      }
    ]
  })
};
</script>
<style scoped>
.cards {
  font-family: "NanumSquare", sans-serif !important;
  width: 25%;
  height: 350px;
}

img,
picture,
source {
  width: 100%;
  height: 100%;
}

@media screen and (max-width: 960px) {
  .cards {
    width: 100%;
    height: 100%;
    margin-top: 40px;
  }
}
</style>
