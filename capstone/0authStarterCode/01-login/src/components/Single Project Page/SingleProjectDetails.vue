<template>
  <div>
    <head>Project Details</head>
    <v-card max-width="400" class="mx-auto">
      <v-app-bar dark color="pink">
        <v-toolbar-title>Selected Project</v-toolbar-title>
        <v-spacer></v-spacer>

      </v-app-bar>
    </v-card>
    <v-card>

      <v-card class="projTile"
      v-for="project in projCards"
      v-bind:key="project">
          <project-tile />
    </v-card>
  </div>
</template>

<script>
import ProjectTile from '../Dashboard/ProjectTile.vue'

export default {
  components: { ProjectTile },
  name: "projDetails",
  data() {
    return {
      projCards:{}      
    }
  }

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
</style>