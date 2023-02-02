<template>
  <div class="nav-container">
      <landing-page-nav />
  </div>
</template>

<script>
import LandingPageNav from './Landing Page/LandingPageNav.vue';

export default {
  components: {
    LandingPageNav
  }
}
</script>

<style>
@media only screen and (max-width: 767px){

    .nav-container {
        background-color: white;
        overflow: hidden;
        position: sticky;
        bottom: 0;
        width: 100%;
        
    }

}
</style>