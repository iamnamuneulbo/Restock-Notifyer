import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import vuetify from "./plugins/vuetify";
import firebase from "firebase/app";
import "firebase/auth";
import "firebase/firestore";

let firebaseConfig = {
  apiKey: "AIzaSyBkp9H7OCIXeofXhfToQxNesu9GGjSvV7U",
  authDomain: "restocknotifyer.firebaseapp.com",
  databaseURL: "https://restocknotifyer.firebaseio.com",
  projectId: "restocknotifyer",
  storageBucket: "restocknotifyer.appspot.com",
  messagingSenderId: "462307051096",
  appId: "1:462307051096:web:b5d4dd7592820103a2ac2d",
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);

// firebase.auth().onAuthStateChanged(user => { });
// firebase.database().ref('/path/to/ref').on('value', snapshot => { });
// firebase.messaging().requestPermission().then(() => { });
// firebase.storage().ref('/path/to/ref').getDownloadURL().then(() => { });

Vue.config.productionTip = false;
Vue.use(firebase);
new Vue({
  router,
  vuetify,
  render: (h) => h(App),
}).$mount("#app");
