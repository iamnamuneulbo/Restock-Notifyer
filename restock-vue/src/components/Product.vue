<template>
  <div class="page">
    <InsertProduct v-on:insertProduct="insertProduct" />
    <ProductTable :products="products" v-on:deleteProduct="deleteProduct" />
    <!-- <ProductTable @select="selectProducts" /> -->
  </div>
</template>

<script>
import InsertProduct from "../components/InsertProduct";
import ProductTable from "../components/ProductTable";
import firebase from "firebase/app";
import "firebase/auth";
import "firebase/firestore";
import { v4 as uuidv4 } from "uuid";

export default {
  name: "Product",
  components: {
    InsertProduct,
    ProductTable
  },
  data() {
    return {
      db: null,
      productRef: null,
      products: []
    };
  },
  methods: {
    databaseInit() {
      this.db = firebase.firestore();
      this.productRef = this.db.collection("products");
    },
    pushList(url, uuid) {
      this.products.push({
        prdNo: this.products.length + 1,
        prdImg:
          "https://shop-phinf.pstatic.net/20170927_252/thedama_1506475853176vgSQN_JPEG/29783012795655265_-283706787.jpg?type=m450",
        prdUrl: url,
        prdName: url,
        uuid: uuid,
        dialog: false
      });
    },
    selectProducts() {
      firebase.auth().onAuthStateChanged(user => {
        if (user) {
          this.productRef
            .where("userId", "==", user.uid)
            .get()
            .then(snapshot => {
              if (snapshot.empty) {
                return;
              }
              this.products = [];
              snapshot.forEach(doc => {
                this.pushList(doc.data().productUrl, doc.data().uuid);
              });
            });
        }
      });
    },
    insertProduct(url) {
      let uuid = uuidv4();

      this.pushList(url, uuid);

      firebase.auth().onAuthStateChanged(user => {
        if (user) {
          this.productRef.add({
            uuid: uuid,
            userId: user.uid,
            productUrl: url
          });
        }
      });
    },
    deleteProduct(uuid) {
      firebase.auth().onAuthStateChanged(user => {
        if (user) {
          this.productRef
            .where("uuid", "==", uuid)
            .get()
            .then(snapshot => {
              if (snapshot.empty) {
                this.products = null;
                return;
              }
              snapshot.forEach(doc => {
                doc.ref.delete();
              });
            });
        }
      });
    }
  },
  created() {
    this.databaseInit();
    this.selectProducts();
  }
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
