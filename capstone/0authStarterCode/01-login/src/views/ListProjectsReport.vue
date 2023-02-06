<template>
  <div class="container">
    <logo-image />
    <list-all-project-report />
  </div>
</template>

<script>
import ListAllProjectReport from '../components/Reports/ListAllProjectReport.vue';
import LogoImage from '../components/LogoImage.vue';

export default {
    components: {
      LogoImage,
      ListAllProjectReport
    },
  }
</script>

<style>

</style>