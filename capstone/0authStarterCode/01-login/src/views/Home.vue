<template>
  <div>
    <hero />
    <hr />
    <proj-tile />
    <task-tile />
    <home-content />
  </div>
</template>

<script lang="ts">
import Hero from "../components/Hero.vue";
import HomeContent from "../components/HomeContent.vue";
import projTile from "../components/Dashboard/ProjectTile.vue";
import TaskTile from '../components/Dashboard/TaskTile.vue';

export default {
  name: "home-view",
  components: {
    Hero,
    HomeContent,
    projTile,
    TaskTile
  },
};
</script>

<style lang="css" scoped>
.next-steps .fa-link {
    margin-right: 5px;
}

body {
  display: grid;
  
}
</style>
