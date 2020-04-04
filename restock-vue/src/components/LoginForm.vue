<template>
  <v-row align="center" justify="center" class="ma-12">
    <v-col cols="12" xs="10" sm="6" md="6" lg="3" xl="3">
      <v-card class="elevation-12">
        <v-toolbar color="light-blue lighten-1" dark flat>
          <v-toolbar-title>Login</v-toolbar-title>
        </v-toolbar>
        <v-card-text>
          <v-form autocomplete="on" v-model="valid">
            <v-text-field
              label="E-mail"
              name="login"
              prepend-icon="mdi-account"
              type="text"
              v-model="userEmail"
              :rules="emailRules"
              @keydown.enter="loginRequest"
            />
            <v-text-field
              id="password"
              label="Password"
              name="password"
              prepend-icon="mdi-lock"
              type="password"
              v-model="userPassword"
              :rules="passwordRules"
              @keydown.enter="loginRequest"
            />
          </v-form>
        </v-card-text>
        <v-card-text class="py-0">
          <v-slide-y-transition>
            <v-alert type="error" v-if="loginErrorAlert">{{errorMessage}}</v-alert>
          </v-slide-y-transition>
        </v-card-text>
        <v-card-actions>
          <v-btn color="light-blue lighten-1 white--text" @click="goToSignUpPage">Sign Up</v-btn>
          <v-spacer />
          <v-btn color="light-blue lighten-1 white--text" @click="loginRequest">Login</v-btn>
        </v-card-actions>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import firebase from "firebase";

export default {
  name: "LoginForm",
  props: {
    source: String
  },
  data() {
    return {
      valid: true,
      userEmail: "",
      userPassword: "",
      loginErrorAlert: false,
      errorMessage: "",

      emailRules: [
        v => !!v || "E-mail is required",
        v => /.+@.+/.test(v) || "E-mail must be valid"
      ],
      passwordRules: [
        v => !!v || "Password is required",
        v =>
          /^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=.{8,})/.test(v) ||
          "Min. 8 characters with at least one capital letter, a number and a special character."
      ]
    };
  },
  methods: {
    goToSignUpPage() {
      this.$router.push("/signup");
    },
    loginRequest() {
      firebase
        .auth()
        .signInWithEmailAndPassword(this.userEmail, this.userPassword)
        .then(data => {
          this.$router.push("/");
        })
        .catch(err => {
          let message;
          
          switch (err.code) {
            case "auth/invalid-email":
              message = "유효하지 않은 메일입니다";
              break;
            case "auth/user-disabled":
              message = "정지된 사용자 입니다.";
              break;
            case "auth/user-not-found":
              message = "사용자를 찾을 수 없습니다.";
              break;
            case "auth/wrong-password":
              message = "잘못된 패스워드 입니다.";
              break;
          }

          this.errorMessage = message;
          this.loginErrorAlert = true;
          setTimeout(() => {
            this.loginErrorAlert = false;
          }, 2000);
        });
    }
  }
};
</script>

<style scoped>
</style>