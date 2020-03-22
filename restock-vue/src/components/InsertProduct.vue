<template>
  <v-form>
    <v-container>
      <v-row>

        <v-col cols="12" sm="11">
          <v-text-field
            label="상품 URL 입력"
            hint="www.example.com"
            persistent-hint
            v-model="newProduct.prdUrl"
          ></v-text-field>
        </v-col>
        
        <v-col cols="12" sm="1">
         <v-btn class="mr-4" @click="requestInsert">추가</v-btn>
        </v-col>
        
      </v-row>
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
    };
  },
  methods: {
    requestInsert: function() {
      if (
        this.newProduct.prdUrl !== null &&
        this.newProduct.prdUrl !== undefined &&
        this.newProduct.prdUrl !== ""
      ) {
        // instance.post("/product", this.newProduct).then(() => {
        //   this.$emit("insert");
        // });
      }
      else  {
        alert("필수값: URL");
      }
    },
  },
};
</script>

<style scoped>
</style>
