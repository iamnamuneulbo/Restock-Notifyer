<template>
  <v-container>
    <v-row justify="center">
      <v-col cols="12">
        <v-simple-table id="product-table">
          <template v-slot:default>
            <thead v-if="products.length == 0" class="progress">
              <v-progress-circular indeterminate color="light-blue"></v-progress-circular>
            </thead>
            <!-- <thead class="progress">
              <v-slide-y-transition>
                <v-alert type="warning">등록된 상품이 없습니다. 상품을 추가해주세요.</v-alert>
              </v-slide-y-transition>
            </thead> -->
            <thead v-else>
              <tr>
                <th class="text-left">#</th>
                <th class="text-left">상품 이미지</th>
                <th class="text-left">상품명</th>
                <th class="text-left">삭제</th>
              </tr>
            </thead>
            <tbody id="product-rows">
              <tr v-for="(product, index) in products" :key="index">
                <th scope="row">{{ product.prdNo }}</th>
                <td>
                  <img :src="product.prdImg" width="100%" />
                </td>
                <td>
                  <a :href="product.prdUrl" target="_blank">{{ product.prdName }}</a>
                </td>
                <td>
                  <v-row justify="center">
                    <v-dialog v-model="product.dialog" max-width="290">
                      <template v-slot:activator="{ on }">
                        <v-btn
                          icon
                          color="red"
                          href="#"
                          data-toggle="modal"
                          data-target="#modalDelete"
                          v-on="on"
                        >
                          <v-icon>mdi-delete</v-icon>
                        </v-btn>
                      </template>
                      <v-card>
                        <v-card-title class="headline">삭제하시겠습니까?</v-card-title>
                        <v-card-text>{{ product.prdName }}</v-card-text>
                        <v-card-actions>
                          <v-spacer></v-spacer>
                          <v-btn color="blue-grey lighten-2" text @click="product.dialog = false">No</v-btn>
                          <v-btn color="light-blue" text @click="removeEvent(product)">Yes</v-btn>
                        </v-card-actions>
                      </v-card>
                    </v-dialog>
                  </v-row>
                </td>
              </tr>
            </tbody>
          </template>
        </v-simple-table>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "ProductTable",
  props: ["products"],
  data() {
    return {
      deletedProduct: {
        prdId: ""
      },
      dialog: false
    };
  },
  methods: {
    removeEvent(product) {
      product.dialog = false;
      let index = this.products.indexOf(product);
      this.products.splice(index, 1);
      //delete 요청
      this.$emit("deleteProduct", product.uuid);
    }
  }
};
</script>

<style scoped>
a {
  text-decoration: none;
  color: black;
}

.progress {
  text-align: center;
}

/*
##Device = Desktops
##Screen = 1281px to higher resolution desktops
##Device = 데스크탑
##Screen = 1281px 이상 해상도 데스크탑
*/
@media (min-width: 1281px) {
  td:nth-child(2) img {
    width: 100%;
    max-width: 100px;
  }
}

/*
##Device = Laptops, Desktops
##Screen = B/w 1025px to 1280px
##Device = 랩탑, 데스크탑
##Screen = 1025px에서 1280px 사이
*/
@media (min-width: 1025px) and (max-width: 1280px) {
  td:nth-child(2) img {
    width: 100%;
    max-width: 100px;
  }
}

/*
##Device = Tablets, Ipads (portrait),
##Screen = B/w 768px to 1024px
##Device = 태블릿, 아이패드(세로),
##Screen = 768px에서 1024px 사이
*/
@media (min-width: 768px) and (max-width: 1024px) {
  td:nth-child(2) img {
    width: 100%;
    max-width: 100px;
  }
}

/*
##Device = Tablets, Ipads (landscape)
##Screen = B/w 768px to 1024px
##Device = 태블릿, 아이패드(가로)
##Screen = 768px에서 1024px 사이
*/
@media (min-width: 768px) and (max-width: 1024px) and (orientation: landscape) {
}

/*
##Device = Low Resolution Tablets, Mobiles (Landscape)
##Screen = B/w 481px to 767px
##Device = 저해상도 태블릿, 모바일(가로)
##Screen = 481px에서 767px 사이
*/
@media (min-width: 481px) and (max-width: 767px) {
}

/*
##Device = Most of the Smartphones Mobiles (Portrait)
##Screen = B/w 320px to 479px
##Device = 대부분의 스마트폰 모바일 기기(세로)
##Screen = 320px에서 479px 사이
*/
@media (min-width: 320px) and (max-width: 480px) {
}
</style>
