<template>
  <div class="nav-container">
    <div class="logo-container">
      <logo-image />
    </div>
    <!-- <h1>TESTING SINGLE PROJECT</h1> -->
    <!-- <single-project-details/> -->
    <v-layout row>
      <v-flex
        xs12
        sm6
        m4
        lg3
        v-for="project in currentProject"
        v-bind:key="project.id"
      >
      
        <v-card-text class="pa-0">
            <v-card >
              <v-text class="h2 d-flex justify-center single-line">
                    {{project.projectTitle}}
              </v-text>
            </v-card>
            
          <v-text-field class="text--primary" v-model="newProjectTitle" :placeholder="project.projectTitle">
          </v-text-field>
          <!-- <font-awesome-icon icon="fa-pencil" size="x" /> -->
          <v-container fluid>
            <v-row>
              <v-col cols="4" class="pa-0">
                <!-- <v-img class="pa-2 mt-">{{ project.projectimg }}</v-img> -->
                <v-btn  class="mt-10" @click="updateProject()">UPDATE</v-btn>
              </v-col>
              <v-col cols="8" class="pa-0">
                
                <v-textarea class="text--primary" :placeholder="project.projectDescription"
                v-model="newProjectDescription"></v-textarea>
              </v-col>
            </v-row>
          </v-container>
        </v-card-text>

        <v-card class="current-project"><h2>Project Tasks</h2></v-card>

        <v-col cols="12" sm="6" class="pyx-1 text-center">
          <v-btn-toggle v-model="timeFilter">
            <v-btn>All</v-btn>
            <v-btn>Today</v-btn>
            <v-btn>Week</v-btn>
            <v-btn>Done</v-btn>
          </v-btn-toggle>
        </v-col>
        <v-card>
          <table>
            <thead>
              <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Due Date</th>
                <th>Active</th>
              </tr>
            </thead>
            <tbody>
              <tr
                v-for="task in filteredList"
                v-bind:key="task.id"
                v-bind:class="{ disabled: task.isCompleted === false }"
              >
                <td>{{ task.taskTitle }}</td>
                <td>{{ task.taskDescription }}</td>
                <td>{{ task.taskDueDate }}</td>
                <td>
                  <button
                    v-on:click="flipStatus(task.id)"
                    class="btnEComplete"
                    v-if="!task.taskIsCompleted"
                  >
                    Complete
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </v-card>
      </v-flex>
    </v-layout>

  </div>
</template>

<script lang="ts">
import TaskTile from "../components/Dashboard/TaskTile.vue";
import LogoImage from "../components/LogoImage.vue";
import SingleProjectDetails from "../components/Single Project Page/SingleProjectDetails.vue";
import service from "../services/ServerService.js";
import { useAuth0 } from "@auth0/auth0-vue";

export default {
  components: {
    LogoImage,
    SingleProjectDetails,
    TaskTile,
  },

  data() {
    return {
      currentProject: [],
      newProjectTitle: "",
      newProjectDescription: "",
      taskList: [],
      filter: {
        taskIsCompleted: false,
        DueDate: "",
      },
      timeFilter: null,
      
    };
  },

  created() {
    //  this.currentProject = this.$route.params.id;
    const idPassed = this.$route.params.id;
    service.getProjectByProjectId(idPassed).then((response) => {
      this.currentProject = response.data;
      // console.log(response.data)
    });

    const auth0 = useAuth0();

    service.verifyThroughEmail({ email: auth0.user.value.email });

    service
      .getUserByEmail(`${auth0.user.value.email}`)
      .then((response) => {
        const { ismanager, isactivated, userid } = response.data;
        if (response.data == null) {
          window.location.reload();
        }

        console.log(response.data);
        console.log(`isManager: ${ismanager}`);
        console.log(`isActivated: ${isactivated}`);
        console.log(`userId: ${userid}`);

        if (!isactivated) {
          console.log("User is not activated, logging out");
          auth0.logout({
            logoutParams: {
              returnTo: window.location.origin,
            },
          });
        }

        if (!ismanager) {
          //Get Tasks for User
          //MAKE SURE THAT TASKS ARE POPULATED BY PROJECT ID!!!!
          service.getAllTasksByUserId(`${userid}`).then((response) => {
            this.taskList = response.data;
            console.log(response.data);
          });
        } else {
          //Get All Tasks
          console.log("Getting ALL Tasks");
          service
            .getAllTasks()
            .then((response) => {
              this.taskList = response.data;
              console.log(response.data);
            })
            .catch((error) => {
              console.error(error);
            });
        }
      })
      .catch((error) => {
        console.error(error);
      });
  },

  methods: {

    updateProject() {
      const newProject = {projectTitle: this.newProjectTitle, projectDescription: this.newProjectDescription};
      console.log(newProject);
      console.log(newProject.id);
      service.updateProject(this.$route.params.id, newProject).then(() => {
        // window.alert("Project info updated.");
        this.$router.push({ name: "dashboard" });
      });
    },
    flipStatus(id) {
      this.taskList.forEach((task) => {
        if (task.id == id) {
          if (!task.taskIsCompleted) {
            task.taskIsCompleted = true;
          } else {
            task.taskIsCompleted = false;
          }
        }
      });
    },
    dateDifference(today, due) {

      
      let t1 = today.getTime();
      let t2 = due.getTime();

      return Math.floor((t2 - t1) / (24 * 3600 * 1000));
    },
  },
  computed: {
    filteredList() {
      let filteredTasks = this.taskList;
      if (!this.filter.taskIsCompleted && this.timeFilter === 0) {
        filteredTasks = filteredTasks.filter((task) => !task.taskIsCompleted);
      }
      if (!this.filter.taskIsCompleted && this.timeFilter === 1) {
        filteredTasks = filteredTasks.filter(
          (task) =>
            this.dateDifference(new Date(), new Date(task.taskDueDate)) == 0
        );
      }
      if (!this.filter.taskIsCompleted && this.timeFilter === 2) {
        filteredTasks = filteredTasks.filter(
          (task) =>
            this.dateDifference(new Date(), new Date(task.taskDueDate)) <= 7 &&
            this.dateDifference(new Date(), new Date(task.taskDueDate)) > 0 &&
            !task.taskIsCompleted
        );
      }
      if (this.timeFilter === 3) {
        filteredTasks = filteredTasks.filter((task) => task.taskIsCompleted);
      }

      return filteredTasks;
    },
  },
};
</script>

<style>
@media only screen and (max-width: 767px) {
  .nav-container {
    padding: 0 6% 6% 6%;
    display: flex;
    flex-direction: column;
    min-height: 100vh;
  }
  .logo-container {
    display: flex;
    justify-self: stretch;
    justify-content: space-around;
    flex-flow: row wrap;
    align-items: stretch;
    padding: 1em;
  }
  .current-project {
    display: inline-flex;
    
    width: 75vw;
    margin: 5px;
    border: 2px solid;
    border-radius: 5%;
    text-align: center;
    color: #335974;
    background-color: #78b2c6;
  }

  .cp-desc {
    width: 70vw;
    height: 200px;
    color: #335974;
    border: lightgray 2px solid;
    border-radius: 10px;
  }

  .tile-container {
    display: flex;
    flex-wrap: nowrap;
    overflow-x: auto;
  }

  table {
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
      Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
    background-color: white;
    margin-top: 5px;
    width: 100%;
  }
  th {
    text-transform: uppercase;
    font-size: 12px;
    padding: 0px 10px 0px 10px;
  }
  td {
    padding: 10px;
    font-size: 11px;
  }
  .btnEComplete {
    margin-right: 5px;
    background-color: #335974;
    color: white;
    border-color: black;
    border-radius: 5px;
    padding: 5px;
  }
}
</style>