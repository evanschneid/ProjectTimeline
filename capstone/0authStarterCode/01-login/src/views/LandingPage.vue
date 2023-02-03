<template>
  <div class="nav-container">
    <hero />
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

@media only screen and (max-width: 390px) {
  .nav-container {
    grid-template-columns: 1fr;
    padding: 20px;
    width: 100%;
    margin: 0px;
  }
}

@media only screen and (min-width: 768px) {
  .nav-container {
    grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-template-areas: 
    "header header header header"
    "sidebar content content content"
    "footer footer footer footer";
    padding: 10px;
    width: 100%;
  }
}

.next-steps .fa-link {
    margin-right: 5px;
}

body {
  display: grid;
  
}
</style>
