<template>
  <div>
    <div v-for="project in projList" v-bind:key="project">

    <v-card max-width="400" class="mx-auto">
      <v-app-bar dark color="pink">
        <v-toolbar-title>Selected Project</v-toolbar-title>
        <v-spacer></v-spacer>

      </v-app-bar>
    </v-card>
    <v-card>
      <div class="topBar">Selected Project 2</div>
      <font-awesome-icon icon="fa-regular fa-star" />
      <v-card class="projDesc">
        <h2>DESCRIPTION</h2>
      <v-btn variant="outlined" id="taskBtn">
        Project Tasks
      </v-btn>
    </div>
  </div>
</template>

<script>
import ProjectTile from '../Dashboard/ProjectTile.vue'

export default {
  components: { ProjectTile },
  name: "projDetails",
  data() {
    return {
      projList:[]     
    }
  }

}
</script>

<style>

.projDesc {
  display: flex;
  flex-basis: 60%;
  justify-content: flex-end;
}

.fa-solid fa-star {
  display: flex;
}

#taskBtn {
  width: 100%;
  height: 75px;
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
</style>