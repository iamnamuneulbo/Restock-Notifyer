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

        <v-list-item link @click="goToProductPage" v-if="userId != ''">
          <v-list-item-action>
            <v-icon>mdi-format-list-numbered</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>My List</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item link @click="logoutRequest" v-if="userStatus">
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
      <v-toolbar-title @click="goToMainPage">재입고 알림 서비스</v-toolbar-title>
    </v-app-bar>

    <v-content>
      <v-sheet id="scrolling-techniques-7" class="overflow-y-auto" :max-height="windowHeight - 100">
        <v-container fluid>
          <v-row align="center" justify="center">
            <v-col>
              <router-view />
            </v-col>
          </v-row>
        </v-container>
      </v-sheet>
    </v-content>

    <v-footer color="light-blue" app>
      <div class="footer">
        <span class="user-info white--text">{{userId}}</span>
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
    windowHeight: 0,
    drawer: false,
    notificationIcon: "mdi-bell",
    userStatus: false,
    userId: ""
  }),
  methods: {
    setUserState() {
      firebase.auth().onAuthStateChanged(user => {
        if (user) {
          this.userId = user.email;
          this.userStatus = true;
        }
      });
    },
    getWindowHeight() {
      this.windowHeight = window.innerHeight;
    },
    goToMainPage() {
      this.drawer = false;
      this.$router.push("/");
    },
    goToProductPage() {
      this.drawer = false;
      this.$router.push("/product");
    },
    goToLoginPage() {
      this.drawer = false;
      this.$router.push("/login");
    },
    logoutRequest() {
      this.drawer = false;
      this.userStatus = false;
      this.userId = "";

      firebase
        .auth()
        .signOut()
        .then(() => {})
        .catch(error => {
          alert(error);
        });
    }
  },
  mounted() {
    this.getWindowHeight();
    this.setUserState();
  },
  watch: {
    userId() {},
    userStatus() {},
    $router() {
      this.setUserState();
    }
  }
};
</script>

<style scoped>
footer {
  display: block !important;
}
.user-info {
  float: left;
}
.year {
  float: right;
}
</style>