<template>
  <v-app id="inspire">
    <v-navigation-drawer v-model="drawer" app>
      <v-list dense>
        <v-list-item link @click="goToMainPage">
          <v-list-item-action>
            <v-icon>mdi-home</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Home</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item link @click="logout" v-if="authStatus">
          <v-list-item-action>
            <v-icon>mdi-logout</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Logout</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item link @click="goToLoginPage" v-else>
          <v-list-item-action>
            <v-icon>mdi-login</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Login</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar
      app
      absolute
      color="light-blue"
      elevate-on-scroll
      scroll-target="#scrolling-techniques-7"
      dark
    >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer" />
      <v-toolbar-title>재입고 알림 서비스</v-toolbar-title>
    </v-app-bar>
    <v-content>
      <v-sheet id="scrolling-techniques-7" class="overflow-y-auto" :max-height="windowHeight - 100">
        <v-container fluid>
          <v-row align="center" justify="center">
            <v-col>
              <router-view v-on:userInfo="userInfo" />
            </v-col>
          </v-row>
        </v-container>
      </v-sheet>
    </v-content>
    <v-footer color="light-blue" app>
      <div class="footer">
        <span class="user-email white--text">{{userEmail}}</span>
        <span class="year white--text text-right">&copy; {{ new Date().getFullYear() }}</span>
      </div>
    </v-footer>
  </v-app>
</template>

<script>
import firebase from "firebase";

export default {
  name: "App",

  components: {},
  props: {
    source: String
  },
  data: () => ({
    userEmail: "xxx@gmail.com",
    windowHeight: 0,
    drawer: false,
    notificationIcon: "mdi-bell",
    authStatus: false
  }),
  mounted() {
    this.getWindowHeight();
  },
  methods: {
    getWindowHeight: function() {
      this.windowHeight = window.innerHeight;
    },
    goToMainPage: function() {
      this.drawer = false;
      this.$router.push("/");
    },
    goToLoginPage: function() {
      this.drawer = false;
      this.$router.push("/login");
    },
    userInfo: function(result) {
      console.log(result);
      this.authStatus = true;
      this.userEmail = result.email;
    },
    logout: function() {
      this.drawer = false;
      firebase
        .auth()
        .signOut()
        .then(function() {
        })
        .catch(function(error) {
          alert(error);
        });
      this.userEmail = "Logout";
    }
  }
};
</script>

<style scoped>
footer {
  display: block !important;
}
.user-email {
  float: left;
}
.year {
  float: right;
}
</style>