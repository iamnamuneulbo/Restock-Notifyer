<template>
  <v-row align="center" justify="center" class="ma-12">
    <v-col cols="12" xs="10" sm="6" md="6" lg="3" xl="3">
      <v-card class="elevation-12">
        <v-toolbar color="light-blue lighten-1" dark flat>
          <v-toolbar-title>Login</v-toolbar-title>
        </v-toolbar>
        <v-card-text>
          <v-form>
            <v-text-field label="E-mail" name="login" prepend-icon="person" type="text" />
            <v-text-field
              id="password"
              label="Password"
              name="password"
              prepend-icon="lock"
              type="password"
            />
          </v-form>
        </v-card-text>
        <v-card-actions>
          <v-btn color="light-blue lighten-1 white--text" @click="goToSignUpPage">Sign Up</v-btn>
          <v-spacer />
          <v-btn color="light-blue lighten-1 white--text">Login</v-btn>
        </v-card-actions>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
export default {
  name: "LoginForm",
  props: {
    source: String
  },
  data() {
  },
  methods: {
    goToSignUpPage: function() {
      this.$router.push("/signup");
    },
  }
};
</script>

<style scoped>
</style>