<template>
  <div id="footer">
      <div class="login-btn-container" v-if="!isAuthenticated">
          <nav-login-btn />
      </div> 
      <div class="main-btn-container" v-if="isAuthenticated"> 
          <div class="navbar-nav d-md-none" v-if="isAuthenticated">
                <a id="qsLogoutBtn" href="#" class="dropdown-item" @click.prevent="logout">
                <font-awesome-icon class="mr-3" icon="power-off" />Log out {{ user ? user.name : "" }}
                </a>
          </div>
          <div class="main-btn-list">
              <div class="main-btn"><nav-dash-board-btn /></div>
              <div class="main-btn"><nav-task-btn /></div>
              <div class="main-btn"><nav-report-btn /></div>
          </div>
      </div>
  </div>
</template>
<script>
import NavDashBoardBtn from './Dashboard/NavDashBoardBtn.vue';
import NavLoginBtn from './Landing Page/NavLoginBtn.vue';
import NavReportBtn from './Reports/NavReportBtn.vue';
import NavTaskBtn from './Tasks/NavTaskBtn.vue';
import { useAuth0 } from '@auth0/auth0-vue';

export default {
    components: {
        NavLoginBtn,
        NavDashBoardBtn,
        NavTaskBtn,
        NavReportBtn
    },
    setup() {
        const auth0 = useAuth0();
    
        return {
            isAuthenticated: auth0.isAuthenticated,
            isLoading: auth0.isLoading,
            user: auth0.user,
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
#footer {
    background-color: #78b2c6;
    overflow: hidden;
    position: sticky;
    bottom: 0;
    width: 100%;
    display: flex;
    justify-content: center;
}

.main-btn-container {
    width: 100%;
}

.main-btn-list {
    display: flex;
    justify-content: center;
    flex-flow: row nowrap;
    align-items: center;
}

.main-btn {
  border: 3px solid #78b2c6;
  display: inline-block;
  text-align: center;
  height: auto;
  flex: 1;
}

.login-btn-container {
    background-color: #78b2c6;
    width: 80%;
    height: 100px;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 0;
}


</style>