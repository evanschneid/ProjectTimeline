<template>
  <div>
    <div id="app" class="d-flex flex-column h-100">
      <div class="container flex-grow-1">
      <error />
      <div class="mt-5"> 
        <router-view />
      </div>
    </div>
    </div>
    <!-- <footer class="bg-light text-center p-3">
      <div class="logo"></div>
      <p>
        Sample project provided by
        <a href="https://auth0.com">Auth0</a>
      </p>
    </footer> -->
  </div>
  <footer-nav-bar />
</template>
<script lang="ts">
import { useAuth0 } from '@auth0/auth0-vue';
import FooterNavBar from './components/FooterNavBar.vue';
import { useRouter } from 'vue-router';
import axios from 'axios';

export default {
  components: {
    FooterNavBar
  },
  setup() {
    const auth0 = useAuth0();
    const router = useRouter();
    
    if (auth0.isAuthenticated) {
      router.push('/projects');
    } 
  }
};
</script>
<style>
body, html {
  height: 100%;
  margin: 0;
}


#app {
  height: 100vh;
  overflow: hidden;
}


.mt-5 {
  margin-top: 0%;
}
</style>