import { createRouter as createVueRouter, createWebHashHistory, Router } from "vue-router";
import LandingPage from "../views/LandingPage.vue";
import Profile from "../views/Profile.vue";
import { createAuthGuard } from "@auth0/auth0-vue";
import { App } from 'vue';
import Dashboard from "../views/Dashboard.vue";
import SingleProjectPage from "../views/SingleProjectPage.vue";
import TaskPage from "../views/TaskPage.vue";
import ListProjectsReport from "../views/ListProjectsReport.vue";
import SingleProjectTimeReport from "../views/SingleProjectTimeReport.vue";



export function createRouter(app: App): Router {
  return createVueRouter({
    routes: [
      {
        path: "/",
        name: "landingPage",
        component: LandingPage
      },
      {
        path: "/profile",
        name: "profile",
        component: Profile,
        beforeEnter: createAuthGuard(app)
      },
      {
        path: "/projects",
        name: "dashboard",
        component: Dashboard,
        beforeEnter: createAuthGuard(app)
      },
      {
        path: "/projects/:id",
        name: "project",
        component: SingleProjectPage,
        beforeEnter: createAuthGuard(app)
      },
      {
        path: "/tasks",
        name: "tasks",
        component: TaskPage,
        beforeEnter: createAuthGuard(app)
      },
      {
        path: "/worklog",
        name: "listProjectsReport",
        component: ListProjectsReport,
        beforeEnter: createAuthGuard(app)
      },
      {
        path: "/:userId/worklog/:projectId",
        name: "singleProjectTimeReport",
        component: SingleProjectTimeReport,
        beforeEnter: createAuthGuard(app)
      }
    ],
    history: createWebHashHistory()
  })
}
