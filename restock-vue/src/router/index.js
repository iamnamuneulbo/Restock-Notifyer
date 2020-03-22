import Vue from 'vue';
import VueRouter from 'vue-router';
import MainPage from "../components/MainPage";
// import LoginForm from '../components/my/page/LoginFormPage';

Vue.use(VueRouter);

const routes = [
    {path: '/', component: MainPage},
    // {path: '/login', component: LoginForm},
]

export default new VueRouter({
    routes,
    scrollBehavior () {
        return { x: 0, y: 0 }
    }
})
