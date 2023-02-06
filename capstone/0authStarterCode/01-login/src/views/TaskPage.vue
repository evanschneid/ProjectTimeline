<template>
  <div>
    <div class="logo-container">
      <logo-image />
    </div>
      <h1>TESTING TASK PAGE </h1>
  </div>
</template>

<script>
import LogoImage from '../components/LogoImage.vue';

export default {
  components: {
      LogoImage
  },
}
</script>

<style>
  .logo-container {
    display: flex;
    justify-self: stretch;
    justify-content: space-around;
    flex-flow: row wrap;
    align-items: stretch;
    padding: 1em;
  }
</style>