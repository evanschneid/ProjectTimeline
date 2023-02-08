<template>
  <div class="nav-container">
    <div class="logo-container">
      <logo-image />
    </div>
      <!-- <h1>TESTING SINGLE PROJECT</h1> -->
      <!-- <single-project-details/> -->
        <v-layout row wrap>
          <v-flex xs12 sm6 m4 lg3 v-for="project in currentProject" :key="project.projectid">
            <v-card class="current-project">
              <h1>{{project.projectTitle}}</h1>
            </v-card>
              <v-icon></v-icon>
              <h3 class="cp-desc">{{project.projectDescription}}</h3>

            <v-card class="current-project"><h2>Project Tasks</h2></v-card>
            <task-tile />
          </v-flex>
        </v-layout>
        
      <!-- {{currentProject}} -->
    <!-- <v-card> -->
      <!-- 
      <font-awesome-icon icon="fa-regular fa-star" />
      <div class="projDesc">
        <h2>DESCRIPTION</h2>
      </div>
      <button variant="outlined" id="taskBtn">
        Project Tasks
      </button>
      <button>Update</button> -->
  </div>
</template>

<script>
import TaskTile from '../components/Dashboard/TaskTile.vue';
import LogoImage from '../components/LogoImage.vue';
import SingleProjectDetails from '../components/Single Project Page/SingleProjectDetails.vue';
import service from '../services/ServerService.js';

export default {
  components: {
      LogoImage,
    SingleProjectDetails,
    TaskTile
  },

  data () {
    return {
      // projectID : -1,
      currentProject: {}
    }
  },

  created() {
    //  this.currentProject = this.$route.params.id;
    const idPassed = this.$route.params.id;
    service.getProjectByProjectId(idPassed).then(
      (response) => {
        this.currentProject = response.data;
        console.log(response.data)

      }
    ) 
    // service.getAllProjectByUserId(idPassed).then(
    //   (response) => {
    //     this.currentProject = response.data;
    //   }
    // )
  }, 
  
  

  methods: {
    updateProject() {
    service.updateProject(this.currentProject).then(
      () => {
        windwo.alert("Project info updated.");
        this.$router.push({name : 'dashboard'})
      }
    )}
  }
}

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
    width: 50%;
    height: 200px;
    color: #335974;
    background-color: #78b2c6;
  }

  .tile-container {
    display: flex;
    flex-wrap: nowrap;
    overflow-x: auto;
  }

}


</style>