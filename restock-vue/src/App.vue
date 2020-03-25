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
        <v-list-item link @click="goToLoginPage">
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
              <router-view />
            </v-col>
          </v-row>
        </v-container>
      </v-sheet>
    </v-content>
    <v-footer color="light-blue" app>
      <span class="white--text">&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </v-app>
</template>

<script>
export default {
  name: "App",

  components: {},
  props: {
    source: String
  },
  data: () => ({
    windowHeight: 0,
    drawer: false,
  }),
  mounted() {
    this.getWindowHeight();
  },
  methods: {
    getWindowHeight() {
      this.windowHeight = window.innerHeight;
    },
    goToMainPage() {
      this.drawer = false;
      this.$router.push("/");
    },
    goToLoginPage() {
      this.drawer = false;
      this.$router.push("/login");
    }
  }
};
</script>
