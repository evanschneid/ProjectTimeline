<template>
  <div id="app" class="d-flex flex-column h-100">
  <div class="mt-5">
    <router-view />
    <footer-nav-bar />
  </div>
  </div>
</template>
<script lang="ts">
import { useAuth0 } from '@auth0/auth0-vue';
import FooterNavBar from './components/FooterNavBar.vue';
import { useRouter } from 'vue-router';

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