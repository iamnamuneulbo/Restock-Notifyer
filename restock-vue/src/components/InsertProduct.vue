<template>
  <v-form>
    <v-container>
      <v-row style="height: 56px">
        <v-spacer />
        <v-col cols="10" class="pa-0">
          <v-slide-y-transition>
            <v-alert type="warning" v-if="errorAlert">필수값: URL</v-alert>
          </v-slide-y-transition>
        </v-col>
        <v-spacer />
      </v-row>

      <v-row align="center" justify="center">
        <v-spacer />
        <v-col cols="12" sm="9">
          <v-text-field clearable
            label="상품 URL 입력"
            hint="www.example.com"
            persistent-hint
            v-model="newProduct.prdUrl"
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="1">
          <v-btn class="mr-4" @click="requestInsert">추가</v-btn>
        </v-col>
        <v-spacer />
      </v-row>

      <v-row style="height: 56px"></v-row>
    </v-container>
  </v-form>
</template>

<script>
export default {
  name: "InsertProduct",
  data() {
    return {
      newProduct: {
        userId: "lsk",
        prdUrl: ""
      },
      products: [],
      errorAlert: false,
    };
  },
  methods: {
    requestInsert: function() {
      if (
        this.newProduct.prdUrl !== null &&
        this.newProduct.prdUrl !== undefined &&
        this.newProduct.prdUrl !== ""
      ) {
        this.$emit('addProduct', this.newProduct.prdUrl);
        this.newProduct.prdUrl = "";
        // instance.post("/product", this.newProduct).then(() => {
        //   this.$emit("insert");
        // });
      } else {
        this.errorAlert = true;
        setTimeout(() => {
          this.errorAlert = false;
        }, 2000);
      }
    }
  }
};
</script>

<style scoped>
</style>
