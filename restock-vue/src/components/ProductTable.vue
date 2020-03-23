<template>
  <v-simple-table id="product-table">
    <template v-slot:default>
      <thead>
        <tr>
          <th class="text-left">#</th>
          <th class="text-left">상품 이미지</th>
          <th class="text-left">상품명</th>
          <th class="text-left">삭제</th>
        </tr>
      </thead>
      <tbody id="product-rows">
        <tr>
          <th scope="row">1</th>
          <td>
            <img
              src="https://shop-phinf.pstatic.net/20170927_252/thedama_1506475853176vgSQN_JPEG/29783012795655265_-283706787.jpg?type=m450"
              width="100px"
            />
          </td>
          <td>
            <a
              href="https://smartstore.naver.com/thedama_com/products/376093294"
              target="_blank"
            >[더담아] 소량판매/택배봉투/택배비닐/LDPE/HDPE/폴리백</a>
          </td>
          <td>
            <a
              href="#"
              class="btn btn-danger btn-circle"
              data-toggle="modal"
              data-target="#modalDelete"
              @click="requestRemove"
            >삭제</a>
          </td>
        </tr>
        <tr v-for="(product, index) in foundedproducts" :key="index">
          <td>{{ product.prdId }}</td>
          <td>
            <img :src="product.prdImg" width="100px" />
          </td>
          <td>
            <a :href="product.prdUrl" target="_blank">{{ product.prdName }}</a>
          </td>
          <td>
            <a href="#" @click="requestRemove(product.prdId)">삭제</a>
          </td>
        </tr>
      </tbody>
    </template>
  </v-simple-table>
</template>

<script>
export default {
  name: "ProductTable",
  props: {},
  data() {
    return {
      deletedProduct: {
        prdId: ""
      }
    };
  },
  methods: {
    addProduct: function() {}
    // requestRemove: function(removedId) {
    //   instance.delete("/product/" + removedId).then(() => {
    //     this.$emit("select");
    //   });
    // },
  }
};
</script>

<style scoped>
</style>
