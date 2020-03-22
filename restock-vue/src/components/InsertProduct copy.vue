<template>
  <div class="input-group mb-4" id="url-input-box">
    <div class="input-group-prepend">
      <span class="input-group-text" id="basic-addon">URL</span>
    </div>
    <input
      type="url"
      class="form-control"
      placeholder="상품 URL 입력"
      aria-label="Username"
      aria-describedby="basic-addon"
      id="url-input"
      v-model="newProduct.prdUrl"
    />
    <div class="input-group-append">
      <button
        class="btn btn-outline-secondary"
        type="button"
        id="button-addon"
        @click="requestInsert"
      >추가</button>
    </div>
  </div>
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
