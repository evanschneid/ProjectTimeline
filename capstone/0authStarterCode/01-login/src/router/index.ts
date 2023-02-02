import { createRouter as createVueRouter, createWebHashHistory, Router } from "vue-router";
import Home from "../views/Home.vue";
import Profile from "../views/Profile.vue";
import { createAuthGuard } from "@auth0/auth0-vue";
import { App } from 'vue';
import { faDashboard } from "@fortawesome/free-solid-svg-icons";


export function createRouter(app: App): Router {
  return createVueRouter({
    routes: [
      {
        path: "/",
        name: "home",
        component: Home
      },
      {
        path: "/profile",
        name: "profile",
        component: Profile,
        beforeEnter: createAuthGuard(app)
      },
      // {
      //   path: "/projects",
      //   name: "projects",
      //   component: Projects,
      //   beforeEnter: createAuthGuard(app)
      // },
      // {
      //   path: "/projects/addProj",
      //   name: "addProj",
      //   component: AddProject,
      //   beforeEnter: createAuthGuard(app)
      // }
    ],
    history: createWebHashHistory()
  })
}
