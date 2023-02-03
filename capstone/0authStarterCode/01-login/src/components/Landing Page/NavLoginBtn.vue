<template>
  <div class="nav-container">
    <!-- <nav class="navbar navbar-expand-md navbar-light bg-light"> -->
      <div class="container">
        <div class="navbar-nav d-md-none" v-if="!isAuthenticated && !isLoading">
            <button  @click="login">Log in</button>
        </div>
        <a id="qsLogoutBtn" href="#" class="dropdown-item" @click.prevent="logout">
                  <font-awesome-icon class="mr-3" icon="power-off" />Log out
                </a>
      </div>
    <!-- </nav> -->
  </div>
</template>

<script>
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
            async login() {
                await auth0.loginWithRedirect();
                if (auth0.isAuthenticated) {
                    const { email } = auth0.user;
                    await axios.post('http://localhost:9000/user', { email });
                }
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
        overflow: hidden;
        position: fixed;
        top: 0;
        width: 100%;
    }
}

@media only screen and (max-width: 767px){
    .nav-container {
        overflow: hidden;
        position: sticky;
        bottom: 0;
        width: 100%;
    }

    #qsLoginBtn {
        background-color: white;
        height: 4em;
        width: 100%;
    }

}
</style>
