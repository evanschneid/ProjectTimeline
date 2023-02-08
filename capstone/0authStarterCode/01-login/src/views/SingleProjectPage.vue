<template>
  <div class="nav-container">
    <div class="logo-container">
      <logo-image />
    </div>
      <h1>TESTING SINGLE PROJECT</h1>
      <!-- <single-project-details/> -->
        <h1 class="current-project">{{currentProject.projectTitle}}</h1>
        console.log(currentProject.projectTitle);
      {{currentProject}}
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
import LogoImage from '../components/LogoImage.vue';
import SingleProjectDetails from '../components/Single Project Page/SingleProjectDetails.vue';
import service from '../services/ServerService.js';

export default {
  components: {
      LogoImage,
    SingleProjectDetails
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
    service.getProject(idPassed).then(
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
  width: 100%;
  height: 45px;
  border: 2px solid;
  border-radius: 5%;
  text-align: center;
  
}
</style>