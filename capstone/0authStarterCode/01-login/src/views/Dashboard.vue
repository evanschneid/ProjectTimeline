<template>
  <div class="nav-container">
    <div class="logo-container">
      <logo-image />
    </div>
    <main>
      <h2>Projects</h2>
      <add-project />
      <div class="proj-sort-group">
        <button class="sort-projects-btn" @click="sort=0">All</button>
        <button class="sort-projects-btn" @click="sort=1">Open</button>
        <button class="sort-projects-btn" @click="sort=2">Completed</button>
      </div>
      <proj-tile v-bind="project" v-bind:sort="sort"/>
      <h2>Tasks</h2>
      <task-tile v-bind="tasks" v-bind:sort="sort"/>
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
import AddProject from '../components/AddProject.vue';
import service from '../services/ServerService.js'
import ServerService from '../services/ServerService.js';

export default {
  name: "home-view",

  data() {
    return {
      projList: [],
      taskList: [],
      sort:''
    }
  },

  created() {

    service.getAllProjects().then(
      (response) => {
        this.projList = response.data;
        // console.log(response.data)
      }
    )

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
    LogoImage,
    AddProject
  },
};
</script>,

<style lang="css" scoped>

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
  /* .main-logo {
    width: 100%;
  } */
  .proj-sort-group {
    display: flex;
    justify-content: space-around;
    margin: 1em;
  }
  .sort-projects-btn {
    /* border: solid;
    border-radius: 10px;
    border-color: #335974;
    background-color: #78B2C6; */
    color: #335974;

    transition-duration: 0.5s; 
    padding: 0px 7px 0px 7px;   
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

.next-steps .fa-link {
    margin-right: 5px;
}

body {
  display: grid;
  
}
</style>
