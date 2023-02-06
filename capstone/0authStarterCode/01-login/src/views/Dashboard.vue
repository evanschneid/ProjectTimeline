<template>
  <div class="nav-container">
    <!-- <hero /> -->
    <!-- <hr /> -->
    <main>
      <logo-image />
      <h2>Projects</h2>
      <div class="proj-sort-group">
        <button class="sort-projects-btn">All</button>
        <button class="sort-projects-btn">Upcoming</button>
        <button class="sort-projects-btn">Completed</button>
      </div>
      <div class="projTile" v-for="project in projList" v-bind:key="project.id">
        <p>P# {{project.id}}</p>
        <h4>{{project.projectTitle}}</h4>
        <p>Due date: {{project.projectDueDate}}</p>
    </div> 
      <!-- <proj-tile /> -->
      <h2>Tasks</h2>
      <!-- <task-tile /> -->
      <div class="taskTile" v-for="task in taskList" v-bind:key="task.id">
        <p>P# {{task.id}}</p>
        <h4>{{task.taskTitle}}</h4>
        <!-- <p>Due date: {{project.projectDueDate}}</p> -->
      </div> 
    </main>
       
    <!-- <home-content /> -->
  </div>
</template>

<script lang="ts">
//import Hero from "../components/Hero.vue";
//import HomeContent from "../components/HomeContent.vue";
import projTile from "../components/Dashboard/ProjectTile.vue";
import TaskTile from '../components/Dashboard/TaskTile.vue';
import axios from 'axios'
import { useAuth0 } from '@auth0/auth0-vue';
import router from 'vue-router'; 
import { useRouter } from 'vue-router';
import LogoImage from '../components/LogoImage.vue';

import service from '../services/ServerService.js'
import ServerService from '../services/ServerService.js';

export default {
  name: "home-view",

  data() {
    return {
      projList: [],
      taskList: []
    }
  },

  created() {
      const auth0 = useAuth0()

      ServerService.verifyThroughEmail({ email: auth0.user.value.email})
      //axios.post('http://localhost:9000/user', { email: auth0.user.value.email} )

      //Moving on for now but when a new user registers it needs to do a get request. The get request will fail.
      //The code should restart the browswer and do the get request again. 
      //This time the get request will work and pull their credentials from the database
      
      ServerService.getUserByEmail(`${auth0.user.value.email}`)
      //axios.get(`http://localhost:9000/user?email=${auth0.user.value.email}`)
      .then(response => {
      const { ismanager, isactivated, userid } = response.data;
      if(response.data == null){
        window.location.reload();
      }
      
      console.log(response.data)
      console.log(`isManager: ${ismanager}`);
      console.log(`isActivated: ${isactivated}`);
      console.log(`userId: ${userid}`);
      
      if (!isactivated) {
        console.log("User is not activated, logging out");
        auth0.logout({ logoutParams: {
                returnTo: window.location.origin
                }})
        //const router = useRouter();
        //router.push('http://localhost:3000');
      } 
      
      if (!ismanager) {
          
          //Get Projects for user
          console.log("User is not a manager, getting projects/id");
          console.log(`userId: ${userid}`);
          
          ServerService.getAllProjectsByUserId(`${userid}`).then(response => {
          
          if (response.data !== undefined) {
            //console.log(` userId: ${userid}`);
            console.log(response.data);
            this.projList = response.data;

          } else {
            console.log("No projects to show");
          }
          })
          .catch(error => {
          console.error(error);
          });

          //Get Tasks for User
          ServerService.getAllTasksByUserId(`${userid}`).then(response => {
          this.taskList = response.data; 
          console.log(response.data)
          })
          

      } else {
          //Get All Projects
          
          console.log("User is a manager, getting ALL projects");
          ServerService.getAllProjects()
          
          .then(response => {
          this.projList = response.data;
          console.log(response.data);
          
          })
          .catch(error => {
          console.error(error);
          });

          //Get All Tasks
          console.log('Getting ALL Tasks')
          ServerService.getAllTasks().then(response => {
          this.taskList = response.data;
          console.log(response.data);
          
          })
          .catch(error => {
          console.error(error);
          });
      }
      })
      .catch(error => {
      console.error(error);
      });
  },
  components: {
    //Hero,
    //HomeContent,
    projTile,
    TaskTile,
    LogoImage
  },
};
</script>,

<style lang="css" scoped>

@media only screen and (max-width: 390px) {
  .nav-container {
    grid-template-columns: 1fr;
    padding: 20px;
    width: 100%;
    margin: 0px;
  }
  .proj-sort-group {
    display: flex;
    justify-content: space-around;
    width: 100%;
  }
  .sort-projects-btn {
    border: solid;
    border-radius: 10px;
    border-color: #335974;
    background-color: transparent;
    transition-duration: 0.5s;
    cursor: pointer;    
  }
}

@media only screen and (min-width: 768px) {
  .nav-container {
    grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-template-areas: 
    "header header header header"
    "sidebar content content content"
    "footer footer footer footer";
    padding: 10px;
    width: 100%;
  }
}

.projTile {
  display: flex;
  flex-wrap: wrap;
  padding: 10px;
  margin: 5px;
  border: 5px;
  border-style: solid;
  border-color: #F2D678;
  border-radius: 10%;
  width: 150px;
  height: 150px;
  background-color: #335974;
  color: #F2D678;
}

.next-steps .fa-link {
    margin-right: 5px;
}

body {
  display: grid;
  
}
</style>
