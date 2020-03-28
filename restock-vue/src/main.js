import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify';
import firebase from 'firebase';

var firebaseConfig = {
  apiKey: "AIzaSyBkp9H7OCIXeofXhfToQxNesu9GGjSvV7U",
  authDomain: "restocknotifyer.firebaseapp.com",
  databaseURL: "https://restocknotifyer.firebaseio.com",
  projectId: "restocknotifyer",
  storageBucket: "restocknotifyer.appspot.com",
  messagingSenderId: "462307051096",
  appId: "1:462307051096:web:b5d4dd7592820103a2ac2d"
};
firebase.initializeApp(firebaseConfig);

Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
