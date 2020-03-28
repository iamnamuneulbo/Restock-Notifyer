<template>
  <v-row align="center" justify="center" class="ma-12">
    <v-col cols="12" xs="10" sm="6" md="6" lg="3" xl="3">
      <v-card class="elevation-12">
        <v-toolbar color="light-blue lighten-1" dark flat>
          <v-toolbar-title>Login</v-toolbar-title>
        </v-toolbar>
        <v-card-text>
          <v-form autocomplete="on">
            <v-text-field
              label="E-mail"
              name="login"
              prepend-icon="person"
              type="text"
              v-model="userEmail"
              @keydown.enter="loginRequest"
            />
            <v-text-field
              id="password"
              label="Password"
              name="password"
              prepend-icon="lock"
              type="password"
              v-model="userPassword"
              @keydown.enter="loginRequest"
            />
          </v-form>
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
      userEmail: "",
      userPassword: ""
    };
  },
  methods: {
    goToSignUpPage: function() {
      this.$router.push("/signup");
    },
    loginRequest: async function() {
      let path = "";
      await firebase
        .auth()
        .signInWithEmailAndPassword(this.userEmail, this.userPassword)
        .then(
          function() {
            path = "/";
            alert("로그인 완료");
          },
          function(err) {
            path = "/login"
            alert("에러 : " + err.message);
          }
        );
      this.$router.push(path);
    }
  }
};
</script>

<style scoped>
</style>