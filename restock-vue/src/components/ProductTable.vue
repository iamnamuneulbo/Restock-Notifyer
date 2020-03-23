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
        <tr v-for="(product, index) in products" :key="index">
          <th scope="row">{{ product.prdId }}</th>
          <td>
            <img :src="product.prdImg" width="100px" />
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
                    <v-btn
                      color="light-blue"
                      text
                      @click="dialog = false; requestRemove(product.prdId);"
                    >Yes</v-btn>
                  </v-card-actions>
                </v-card>
              </v-dialog>
            </v-row>
          </td>
        </tr>
      </tbody>
    </template>
  </v-simple-table>
</template>

<script>
export default {
  name: "ProductTable",
  props: ['products'],
  data() {
    return {
      deletedProduct: {
        prdId: ""
      },
      dialog: false,
    };
  },
  methods: {
    
    // requestRemove: function(removedId) {
    //   instance.delete("/product/" + removedId).then(() => {
    //     this.$emit("select");
    //   });
    // },
    
  },
  watch: {
    // products: function() {
    //   this.addProduct(this.products);
    // }
  }
};
</script>

<style scoped>
a {
  text-decoration: none;
  color: black;
}
</style>
