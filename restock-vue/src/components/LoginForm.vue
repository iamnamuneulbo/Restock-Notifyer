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
              prepend-icon="person"
              type="text"
              v-model="userEmail"
              :rules="emailRules"
              @keydown.enter="loginRequest"
            />
            <v-text-field
              id="password"
              label="Password"
              name="password"
              prepend-icon="lock"
              type="password"
              v-model="userPassword"
              :rules="passwordRules"
              @keydown.enter="loginRequest"
            />
          </v-form>
        </v-card-text>
        <v-card-text class="py-0" style="height: 72px">
          <v-slide-y-transition>
            <v-alert type="error" v-if="loginErrorAlert">로그인 실패</v-alert>
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
    goToSignUpPage: function() {
      this.$router.push("/signup");
    },
    loginRequest: async function() {
      let result = await firebase
        .auth()
        .signInWithEmailAndPassword(this.userEmail, this.userPassword)
        .then(
          function(user) {
            return user;
          },
          function(error) {
            return error;
          }
        );

      
      if (!result.message) {
        console.log(result.user);
        this.$emit("setUserEmail");
        this.$router.push("/");
      } else {
        console.log(result.message);
        this.loginErrorAlert = true;
        setTimeout(() => {
          this.loginErrorAlert = false;
        }, 2000);
      }
    }
  }
};
</script>

<style scoped>
</style>