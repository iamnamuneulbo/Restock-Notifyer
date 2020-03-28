<template>
  <v-row align="center" justify="center" class="ma-12">
    <v-col cols="12" xs="10" sm="6" md="6" lg="3" xl="3">
      <v-card class="elevation-12">
        <v-toolbar color="light-blue lighten-1" dark flat>
          <v-toolbar-title>Sign Up</v-toolbar-title>
        </v-toolbar>
        <v-card-text>
          <v-form ref="form" v-model="valid" lazy-validation>
            <v-text-field
              label="E-mail"
              prepend-icon="person"
              v-model="userEmail"
              :rules="emailRules"
              required
            ></v-text-field>
            <v-text-field
              label="Password"
              prepend-icon="lock"
              type="password"
              v-model="userPassword"
              :rules="passwordRules"
              required
            />
            <v-text-field
              id="password-check"
              label="Password Check"
              name="password-check"
              prepend-icon="lock"
              type="password"
              v-model="passwordCheck"
              :rules="passwordCheckRules"
              required
            />

            <!-- <v-checkbox
              v-model="checkbox"
              :rules="[v => !!v || 'You must agree to continue!']"
              label="Do you agree?"
              required
            ></v-checkbox>-->
          </v-form>
        </v-card-text>
        <v-card-actions>
          <v-spacer />
          <v-btn color="light-blue lighten-1 white--text" @click="goToSignUpPage">Sign Up</v-btn>
        </v-card-actions>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
export default {
  name: "SignUpForm",
  props: {
    source: String
  },
  data() {
    return {
      valid: true,

      userEmail: "",
      userPassword: "",
      passwordCheck: "",

      emailRules: [
        v => !!v || "E-mail is required",
        v => /.+@.+/.test(v) || "E-mail must be valid",
      ],
      passwordRules: [
        v => !!v || 'Password is required',
        v => /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=.{8,})/.test(v) || "Min. 8 characters with at least one capital letter, a number and a special character.",
      ],
      passwordCheckRules: [
        v => !!v || "Password is required",
        v => this.userPassword === v || "Password must be valid",
      ],
    };
  },
  methods: {
    goToSignUpPage: function() {
      this.$refs.form.validate();
      this.drawer = false;
      // this.$router.push("/login");
    }
  },
};
</script>

<style scoped>
</style>