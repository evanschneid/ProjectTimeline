<template>
  <div>
    <!-- <div v-for="project in projList" v-bind:key="project.id"> -->
      <h1>hi</h1>
    <!-- </div> -->
  </div>
</template>

<script>
import ProjectTile from '../Dashboard/ProjectTile.vue';

export default {
  components: { ProjectTile },
  name: "single-project-details",
  data() {
    return {
      projList: []   
    }
  },

created () {
  
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