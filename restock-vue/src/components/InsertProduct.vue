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
        <v-col cols="9" sm="11">
          <v-text-field
            id="url-input"
            clearable
            label="상품 URL 입력"
            hint="www.example.com"
            persistent-hint
            v-model="prdUrl"
            @keydown.enter="requestInsert"
          ></v-text-field>
        </v-col>
        <v-col cols="2" sm="1">
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
      prdUrl: null,
      products: [],
      blankErrorAlert: false,
      urlErrorAlert: false
    };
  },
  methods: {
    requestPermission: function() {
      let urlInput = document.getElementById("url-input");
      Notification.requestPermission(function(result) {
        // 요청 거절
        if (result === "denied") {
          // 입력폼 비활성화
          urlInput.setAttribute("disabled", "");

          return;
        }
        // 요청 허용
        else {
          // 입력폼 활성화
          urlInput.removeAttribute("disabled");

          return;
        }
      });
    },
    requestInsert: function() {
      if (
        this.prdUrl === null ||
        this.prdUrl === undefined ||
        this.prdUrl === ""
      ) {
        this.blankErrorAlert = true;
        setTimeout(() => {
          this.blankErrorAlert = false;
        }, 2000);
      } else if (!this.isValidUrl(this.prdUrl)) {
        this.urlErrorAlert = true;
        setTimeout(() => {
          this.urlErrorAlert = false;
        }, 2000);
      } else {
        this.$emit("insertProduct", this.prdUrl);
        this.prdUrl = null;
        // instance.post("/product", this.newProduct).then(() => {
        //   this.$emit("insert");
        // });
      }
    },
    isValidUrl(string) {
      let httpPattern = new RegExp("^(http|https)://", "i");
      let urlPattern = new RegExp(
        "^(https?:\\/\\/)?" + // protocol
        "((([a-z\\d]([a-z\\d-]*[a-z\\d])*)\\.)+[a-z]{2,}|" + // domain name
        "((\\d{1,3}\\.){3}\\d{1,3}))" + // OR ip (v4) address
        "(\\:\\d+)?(\\/[-a-z\\d%_.~+]*)*" + // port and path
        "(\\?[;&a-z\\d%_.~+=-]*)?" + // query string
          "(\\#[-a-z\\d_]*)?$",
        "i"
      );

      return !!httpPattern.test(string) && !!urlPattern.test(string);
    }
  },
  mounted() {
    this.requestPermission();
  }
};
</script>

<style scoped>
</style>
