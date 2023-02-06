<template>
  <div class="nav-container">
    <!-- <nav class="navbar navbar-expand-md navbar-light bg-light"> -->
      <div class="container">
        <div class="navbar-nav d-md-none" v-if="!isAuthenticated && !isLoading">
            <button  @click="login">Log in</button>
        </div>
        
      </div>
    <!-- </nav> -->
  </div>
</template>

<script lang="ts">
import { useAuth0 } from '@auth0/auth0-vue';
import axios from 'axios';


export default {
  name: "NavBar",
  setup() {
    const auth0 = useAuth0();
    
    return {
      isAuthenticated: auth0.isAuthenticated,
      isLoading: auth0.isLoading,
      user: auth0.user,
      login() {
        auth0.loginWithRedirect();
            },
      
    }
  }
};
</script>

<style>

/* @media only screen and (min-width: 768px){
    .nav-container {
        overflow: hidden;
        position: sticky;
        top: 0;
        width: 100%;
    }
} */

@media only screen and (max-width: 767px){
    #footer {
        overflow: hidden;
        position: sticky;
        bottom: 0;
        width: 100%;
        padding: 2% 0 2% 0;
        background-color: #78b2c6;
    }

    .loginBtn {
        background-color: white;
        border: 1px solid black;
        height: 4em;
        width: 100%;
        border-radius: 10px;
        margin: 2% 0 2% 0;
    }

}
</style>
