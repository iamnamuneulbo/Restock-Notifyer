<template>
  <div class="page">
    <Header />
    <Product />
  </div>
</template>

<script>
import Header from "../components/Header";
import Product from "../components/Product";

export default {
  name: "MainPage",
  components: {
    Header,
    Product
  }
};
</script>

<style scoped>
.page {
  margin-left: 10%;
  margin-right: 10%;
  margin-top: 5%;
  margin-bottom: 5%;
}
</style>
