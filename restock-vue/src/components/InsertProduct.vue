<template>
  <v-form>
    <v-container>
      <v-row style="height: 56px">
        <v-spacer />
        <v-col cols="10" class="pa-0">
          <v-slide-y-transition>
            <v-alert type="warning" v-if="blankErrorAlert">필수값: URL</v-alert>
            <v-alert type="warning" v-if="urlErrorAlert">유효하지 않은 URL 입력</v-alert>
          </v-slide-y-transition>
        </v-col>
        <v-spacer />
      </v-row>

      <v-row align="center" justify="center">
        <v-spacer />
        <v-col cols="12" sm="9">
          <v-text-field
            id="url-input"
            clearable
            filled
            label="상품 URL 입력"
            hint="www.example.com"
            persistent-hint
            v-model="newProduct.prdUrl"
            @keydown.enter="requestInsert"
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="1">
          <v-btn
            class="mx-2 mr-4"
            fab
            dark
            small
            color="light-blue lighten-1"
            @click="requestInsert"
          >
            <v-icon dark>mdi-plus</v-icon>
          </v-btn>
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
      blankErrorAlert: false,
      urlErrorAlert: false
    };
  },
  methods: {
    requestPermission: function() {
      let urlInput = document.getElementById("url-input");
      console.log(urlInput);
      Notification.requestPermission(function(result) {
        // 요청 거절
        if (result === "denied") {
          // 입력폼 비활성화
          urlInput.setAttribute("disabled", "true");

          return;
        }
        // 요청 허용
        else {
          // 입력폼 활성화
          urlInput.removeAttribute("disabled");
          urlInput.removeAttribute("filled");

          return;
        }
      });
    },
    requestInsert: function() {
      if (
        this.newProduct.prdUrl == null &&
        this.newProduct.prdUrl == undefined &&
        this.newProduct.prdUrl == ""
      ) {
        this.blankErrorAlert = true;
        setTimeout(() => {
          this.blankErrorAlert = false;
        }, 2000);
      } else if (!this.isValidUrl(this.newProduct.prdUrl)) {
        this.urlErrorAlert = true;
        setTimeout(() => {
          this.urlErrorAlert = false;
        }, 2000);
      } else {
        this.$emit("insertProduct", this.newProduct.prdUrl);
        this.newProduct.prdUrl = "";
        // instance.post("/product", this.newProduct).then(() => {
        //   this.$emit("insert");
        // });
      }
    },
    isValidUrl: string => {
      try {
        new URL(string);
        return true;
      } catch (_) {
        return false;
      }
    }
  },
  beforeCreate() {
    this.requestPermission();
  }
};
</script>

<style scoped>
</style>
