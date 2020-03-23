<template>
  <div>
    <InsertProduct />
    <ProductTable @select="selectProducts" />
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
      products: []
    };
  },
  methods: {
    // selectProducts() {
    //   instance
    //     .get("/product")
    //     .then(response => (this.products = response.data));
    // }
  }
  // created() {
  //   instance.get("/product").then(response => (this.products = response.data));
  //   this.$store.commit("getGoodsModel", this.$route.params.goodsCode);
  //   this.$store.commit("loadCommentByGoodsCode", this.$route.params.goodsCode);
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
