<template>
  <div class="page">
    <InsertProduct v-on:insertProduct="insertProduct" />
    <ProductTable :products="products" />
    <!-- <ProductTable @select="selectProducts" /> -->
  </div>
</template>

<script>
import InsertProduct from "../components/InsertProduct";
import ProductTable from "../components/ProductTable";

export default {
  name: "Product",
  props: {},
  components: {
    InsertProduct,
    ProductTable
  },
  data() {
    return {
      products: [
        {
          prdId: 1,
          prdImg:
            "https://shop-phinf.pstatic.net/20170927_252/thedama_1506475853176vgSQN_JPEG/29783012795655265_-283706787.jpg?type=m450",
          prdUrl: "https://smartstore.naver.com/thedama_com/products/376093294",
          prdName: "1[더담아] 소량판매/택배봉투/택배비닐/LDPE/HDPE/폴리백",
          dialog: false
        },
        {
          prdId: 2,
          prdImg:
            "https://shop-phinf.pstatic.net/20170927_252/thedama_1506475853176vgSQN_JPEG/29783012795655265_-283706787.jpg?type=m450",
          prdUrl: "https://smartstore.naver.com/thedama_com/products/376093294",
          prdName: "2[더담아] 소량판매/택배봉투/택배비닐/LDPE/HDPE/폴리백",
          dialog: false
        },
        {
          prdId: 3,
          prdImg:
            "https://shop-phinf.pstatic.net/20170927_252/thedama_1506475853176vgSQN_JPEG/29783012795655265_-283706787.jpg?type=m450",
          prdUrl: "https://smartstore.naver.com/thedama_com/products/376093294",
          prdName: "3[더담아] 소량판매/택배봉투/택배비닐/LDPE/HDPE/폴리백",
          dialog: false
        }
      ],
      insertedUrl: null,
    };
  },
  methods: {
    // selectProducts() {
    //   instance
    //     .get("/product")
    //     .then(response => (this.products = response.data));
    // },
    insertProduct: function(url) {
      this.insertedUrl = url;
      this.products.push({
        prdId: 4,
        prdImg:
          "https://shop-phinf.pstatic.net/20170927_252/thedama_1506475853176vgSQN_JPEG/29783012795655265_-283706787.jpg?type=m450",
        prdUrl: this.insertedUrl,
        prdName: this.insertedUrl,
        dialog: false
      });
    },
  }
  // created: {
  // instance.get("/product").then(response => (this.products = response.data));
  // this.$store.commit("getGoodsModel", this.$route.params.goodsCode);
  // this.$store.commit("loadCommentByGoodsCode", this.$route.params.goodsCode);
  // },
  // computed: {
  //   getGoodsData() {
  //     let goodsData = this.$store.state.goodsStore.goodsModel;

  //     return goodsData;
  //   }
  // },
  // watch: {
  //   option: function() {
  //     this.addOptions(this.option);
  //   },
  //   selectedOptions: function() {
  //     this.calculateOrderSum();
  //   },
  //   orderSumPrice: function() {},
  //   orderSumQuantity: function() {}
  // }
};
</script>

<style scoped>
</style>
