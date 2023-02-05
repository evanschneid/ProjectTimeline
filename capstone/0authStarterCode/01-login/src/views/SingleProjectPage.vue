<template>
  <div>
      <h1>TESTING SINGLE PROJECT</h1>

      {{currentProject}}
    <!-- <v-card> -->
      <div class="current-project">Selected Project 2</div>
      <font-awesome-icon icon="fa-regular fa-star" />
      <div class="projDesc">
        <h2>DESCRIPTION</h2>
      </div>
      <button variant="outlined" id="taskBtn">
        Project Tasks
      </button>
    <!-- </v-card> -->
    
      <!-- <project-tile />
      
      <form>
        {{projCard}}<br>
        Proj No.: <input type="text" v-model="projCard.projectID" /><br>
        Proj Title.: <input type="text" v-model="projCard.projectTitle" /><br>
        Due Date: <input type="text" v-model="projCard.projectDueDate" />
      </form> -->
  </div>
</template>

<script>

// import service from '../services/ServerService.js';

export default {

  created() {
     this.currentProject = this.$route.params.id;

  // service.getProject(id).then(
  //   (response) => {
  //     this.currentProject = response.data;
  //       }
  // )
  }, 
  
  data () {
    return {
      projectID : -1,
       currentProject: {}
    }
  }
}

// import ProjectTile from '../components/Dashboard/ProjectTile.vue';

// export default {
//   components: { ProjectTile },

//   data() {
//     return {
//       currentProject: {}
//     }
//   },
//   created () {
//   this.projectID = this.$route.params.id;

//   service.getProject(id).then(
//     (response) => {
//       this.currentProject = response.data;
//         }
//   )
// }

// }
</script>

<style>

.current-project {
  display: inline-flex;
  width: 100%;
  height: 45px;
  border: 2px solid;
  border-radius: 5%;
  text-align: center;
}
</style>