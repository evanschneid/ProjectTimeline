<template>
  <div>
      <v-card class="projTile"
      v-for="project in projCards"
      v-bind:key="project">
          <project-tile />
      </v-card>
  </div>
</template>

<script>
import ProjectTile from './ProjectTile.vue'
export default {
    name: "projDetails",
  data() {
    return {
      projCards:{}      
    },
  
  components: { ProjectTile },

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