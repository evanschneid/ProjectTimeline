<template>
  <div class="nav-container">
      <div>
          <nav-login-btn />
      </div> 
      <div class="main-btn-container" v-if="isAuthenticated"> 
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
        }
    }
}
</script>

<style>
@media only screen and (max-width: 767px){

    .nav-container {
        background-color: #78b2c6;
        overflow: hidden;
        position: sticky;
        bottom: 0;
        width: 100%;
 
        /* margin-top: 5%;
        border-top: 5%; */
    }

    .main-btn-list {
        display: flex;
        justify-content: space-around;
        flex-flow: row wrap;
        align-items: stretch;
        margin: 2%;

    }

    .main-btn {
        border: 3px solid #78b2c6;
        flex: auto;
        list-style: none;
        height: auto;
        width: 33.33%;
    }

}
</style>