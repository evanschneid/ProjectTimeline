<template>
  <div>  <!-- body & header -->
      <v-card class="projTile" v-for="projectID in projList" v-bind:key="projectID"> <!-- need to add v-on:click -->
        <p>Project #: {{projectID}}</p>
        <p>{{projectTitle}}</p>
        <p>Due Date: {{projectDueDate}}</p>
      </v-card>
  </div>
</template>

<script>
import service from '../services/ServerService.js';

export default {
  name: "projTile",
  data() {
    return {
      projList:[]
    }
  },
  created () {
    service.getAllProjects().then(
      (response) => {
        this.projList = response.data;
      }
    )
  }
}
</script>

<style>

.projTile {
  display: flex;
  flex-wrap: nowrap;
  padding: 5px;
  margin: 5px;
  border: 1px;
  width: 200px;
  background-color: #F2D678;
}

</style>