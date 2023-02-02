<template>
  <div>
    <hero />
    <hr />
    <proj-tile />
    <home-content />
  </div>
</template>

<script lang="ts">
import Hero from "../components/Hero.vue";
import HomeContent from "../components/HomeContent.vue";
import projTile from "../components/Dashboard/ProjectTile.vue";

export default {
  name: "home-view",
  components: {
    Hero,
    HomeContent,
    projTile
  },
};
</script>

<style lang="css" scoped>
.next-steps .fa-link {
    margin-right: 5px;
}
</style>
