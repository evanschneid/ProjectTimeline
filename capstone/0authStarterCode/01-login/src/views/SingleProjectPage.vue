<template>
  <div>
      <h1>TESTING SINGLE PROJECT</h1>

      <project-tile />
      
      <form>
        {{projCard}}<br>
        Proj No.: <input type="text" v-model="projCard.projectID" /><br>
        Proj Title.: <input type="text" v-model="projCard.projectTitle" /><br>
        Due Date: <input type="text" v-model="projCard.projectDueDate" />
      </form>
  </div>
</template>

<script>
import ProjectTile from '../components/Dashboard/ProjectTile.vue';

export default {
  components: { ProjectTile },

  data() {
    return {
      currentProject: {}
    }
  },
  created () {
  this.projectID = this.$route.params.id;

  service.getProject(id).then(
    (response) => {
      this.currentProject = response.data;
        }
  )
}

}
</script>

<style>

</style>