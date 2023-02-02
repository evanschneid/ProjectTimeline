<template>
  <div>  <!-- body & header -->
  <p class="projTile">{{projList}}</p>
      <v-card class="projTile" v-for="project in projList" v-bind:key="project"> <!-- need to add v-on:click -->
        <p>Project #: {{projectID}}</p>
        <p>{{projectTitle}}</p>
        <p>Due Date: {{projectDueDate}}</p>
      </v-card>

      {{projList}}
      <form v-on:submit.prevent="projList">
        {{projList}}
        Proj No.: <input type="text" v-model="projList.projectID" />
        Proj Title.: <input type="text" v-model="projList.projectTitle" />
        Due Date: <input type="text" v-model="projList.projectDueDate" />
        
      </form>
  </div>
</template>

<script>
// import service from './services/ServerService.js';

export default {
  name: "projTile",
  data() {
    return {
      projList:[
        // {
        //   projectID : 1,
        //   projectTitle : "Test Project",
        //   projectDueDate: 02-28-2023
        // }
      ]
    }
  },
  // created () {
  //   service.getAllProjects().then(
  //     (response) => {
  //       this.projList = response.data;
  //     }
  //   )
  // }
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
  height: 200px;
  background-color: #F2D678;
  color: black;
}

</style>