<template>
<div>
  <div class="background">
        <div class="landing-page-container">
      <div id="main-logo"><logo-image /></div>
      <div class="welcome-text"><welcome-text /></div>
      <div class="desc-text"><landing-page-desc /></div>
    </div>
  </div>

</div>
</template>

<script lang="ts">
import WelcomeText from '../components/Landing Page/WelcomeText.vue';
import LandingPageDesc from '../components/Landing Page/LandingPageDesc.vue';
import LogoImage from '../components/LogoImage.vue';

export default {
  name: "home-view",
  components: {
    WelcomeText,
    LandingPageDesc,
    LogoImage
  },
};
</script>,
    WelcomeText

<style>

@media only screen and (max-width: 767px) {
  .background {
    height: 100%;
    background-color: #78b2c6;
  }

  #btn {
    height: 100vh;
  }

  .landing-page-container {

    display: flex;
    justify-self: stretch;
    justify-content: space-around;
    flex-flow: row wrap;
    align-items: stretch;

    padding: 1em;
  }

  #main-logo {
    width: 75vw;

  }

  .welcome-text {

  }

  .desc-text {
    margin-top: 10em;
  }

}

</style>
