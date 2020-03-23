<template>
  <div class="page">
    <Product />
  </div>
</template>

<script>
import Product from "../components/Product";

export default {
  name: "MainPage",
  components: {
    Product
  }
};
</script>

<style scoped>
.page {
  margin-left: 10%;
  margin-right: 10%;
  margin-bottom: 5%;
}
</style>
