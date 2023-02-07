<template>
  <div>
    <div class="logo-container">
      <logo-image />
    </div>
      <h1>TESTING SINGLE PROJECT</h1>


      {{currentProject}}
    <!-- <v-card> -->
      <div class="current-project">{{currentProject.id}}</div>
      <font-awesome-icon icon="fa-regular fa-star" />
      <div class="projDesc">
        <h2>DESCRIPTION</h2>
      </div>
      <button variant="outlined" id="taskBtn">
        Project Tasks
      </button>
      <button>Update</button>
  </div>
</template>

<script>
import LogoImage from '../components/LogoImage.vue';
import service from '../services/ServerService.js';

export default {
  components: {
      LogoImage
  },

  created() {
    //  this.currentProject = this.$route.params.id;
    const idPassed = this.$route.params.id;
    service.getProject(idPassed).then(
      (response) => {
        this.currentProject = response.data;
      }
    )
  }, 
  
  data () {
    return {
      // projectID : -1,
      currentProject: {}
    }
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