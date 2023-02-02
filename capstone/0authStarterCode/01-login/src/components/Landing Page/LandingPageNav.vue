<template>
  <div class="nav-container">
    <!-- <nav class="navbar navbar-expand-md navbar-light bg-light"> -->
      <!-- <div class="container"> -->
        <div class="navbar-nav d-md-none" v-if="!isAuthenticated && !isLoading">
            <button id="qsLoginBtn" class="btn btn-primary btn-block" @click="login">Log in</button>
        </div>
        <!-- <div>
            <button><font-awesome-icon icon="fa-house" /></i>log in</button>
        </div> -->

      <!-- </div> -->
    <!-- </nav> -->
  </div>
</template>

<script>
import { useAuth0 } from '@auth0/auth0-vue';
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
            logout() {
                auth0.logout({
                logoutParams: {
                    returnTo: window.location.origin
                }
                });
            }
        }
  }
}
</script>

<style>

@media only screen and (min-width: 768px){
    .nav-container {
        background-color: white;
        overflow: hidden;
        position: fixed;
        top: 0;
        width: 100%;
    }
}

@media only screen and (max-width: 767px){
    .nav-container {
        background-color: white;
        overflow: hidden;
        position: sticky;
        bottom: 0;
        width: 100%;
        
    }

    .navbar-nav {
        background-color: black;
        border: 500px;
    }


}
</style>