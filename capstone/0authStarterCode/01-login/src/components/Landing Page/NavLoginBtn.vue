<template>
    <div>
        <a id="qsLogoutBtn" href="#" class="dropdown-item" @click.prevent="logout">
            <font-awesome-icon class="mr-3" icon="power-off" />Log out
        </a> 

    <div id="footer">
        <!-- <nav class="navbar navbar-expand-md navbar-light bg-light"> -->
        <div class="container">
            <div v-if="!isAuthenticated && !isLoading">
                <button class="loginBtn" @click="login">Log in</button>
            </div>
        </div>
        <!-- </nav> -->
    </div>
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
        position: sticky;
        top: 0;
        width: 100%;
    }
}

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
