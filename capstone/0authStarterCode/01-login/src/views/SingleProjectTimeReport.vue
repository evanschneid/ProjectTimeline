<template>
  <div class="nav-container">
    <div class="logo-container">
      <logo-image />
    </div>
    <!-- <timer-button /> -->
      <single-project-report-details />
  </div>
</template>

<script>
import SingleProjectReportDetails from '../components/Reports/SingleProjectReportDetails.vue'
import LogoImage from '../components/LogoImage.vue';
// import TimerButton from '../components/TimerButton.vue';

export default {
  components: { 
      SingleProjectReportDetails, 
      LogoImage,
      // TimerButton
    },

}
</script>

<style>
  .nav-container {
    padding: 0 6% 6% 6%;
    display: flex;
    flex-direction: column;
    min-height: 100vh;
  }

  .logo-container {
    padding: 0 6% 6% 6%;
  }

  .logo-container {
    display: flex;
    justify-self: stretch;
    justify-content: space-around;
    flex-flow: row wrap;
    align-items: stretch;
    padding: 1em;
  }
</style>