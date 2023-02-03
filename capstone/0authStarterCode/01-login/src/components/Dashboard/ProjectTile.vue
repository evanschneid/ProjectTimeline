<template>
  <div>  <!-- body & header -->
      <v-card class="projTile" v-bind:key="project"> <!-- need to add v-on:click -->
        <v-card-text>
          <p>Project #: {{projCard.projectID}}</p>
          <h4>{{projCard.projectTitle}}</h4>
          <p>Due date: {{projCard.projectDueDate}}</p>
        </v-card-text>
      </v-card>

      <form>
        {{projCard}}<br>
        Proj No.: <input type="text" v-model="projCard.projectID" /><br>
        Proj Title.: <input type="text" v-model="projCard.projectTitle" /><br>
        Due Date: <input type="text" v-model="projCard.projectDueDate" />
      </form>
  </div>
</template>

<script>
// import service from './services/ServerService.js';

export default {
  name: "projTile",
  data() {
    return {
      projCard:{}      
    }
  },
  // created () {
  //   service.getAllProjects().then(
  //     (response) => {
  //       this.projCard = response.data;
  //     }
  //   )
  // }
}
</script>

<style>

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

#titleText {
  color: #78B2C6;
}

</style>