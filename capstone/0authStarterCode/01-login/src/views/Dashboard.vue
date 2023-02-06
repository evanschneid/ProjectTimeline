<template>
  <div class="nav-container">
    <!-- <hero /> -->
    <!-- <hr /> -->
    <main>
      <logo-image />
      <timer-button />
      <h2>Projects</h2>
      <proj-tile />
      <h2>Tasks</h2>
      <task-tile />
    </main>
    <!-- <home-content /> -->
  </div>
</template>

<script lang="ts">
//import Hero from "../components/Hero.vue";
//import HomeContent from "../components/HomeContent.vue";
import projTile from "../components/Dashboard/ProjectTile.vue";
import TaskTile from '../components/Dashboard/TaskTile.vue';
import axios from 'axios'
import { useAuth0 } from '@auth0/auth0-vue';
import router from 'vue-router'; 
import { useRouter } from 'vue-router';
import TimerButton from '../components/TimerButton.vue';
import LogoImage from '../components/LogoImage.vue';


export default {
  name: "home-view",
  setup() {
      const auth0 = useAuth0()


      axios.post('http://localhost:9000/user', { email: auth0.user.value.email} )

      //Moving on for now but when a new user registers it needs to do a get request. The get request will fail.
      //The code should restart the browswer and do the get request again. 
      //This time the get request will work and pull their credentials from the database
      
      axios.get(`http://localhost:9000/user?email=${auth0.user.value.email}`)
      .then(response => {
      const { ismanager, isactivated } = response.data;
      if(response.data == null){
        window.location.reload();
      }
      
      console.log(response.data)
      console.log(`isManager: ${ismanager}`);
      console.log(`isActivated: ${isactivated}`);
      
      if (!isactivated) {
        console.log("User is not activated, logging out");
        auth0.logout({ logoutParams: {
                returnTo: window.location.origin
                }})
        //const router = useRouter();
        //router.push('http://localhost:3000');
      } else if (!ismanager) {
          console.log("User is not a manager, getting projects/id");
      } else {
          console.log("User is a manager, getting ALL projects");
          axios.get('http://localhost:9000/projects')
          .then(response => {
          console.log(response.data);
          })
          .catch(error => {
          console.error(error);
          });
      }
      })
      .catch(error => {
      console.error(error);
      });
  },
  components: {
    //Hero,
    //HomeContent,
    projTile,
    TaskTile,
    TimerButton,
    LogoImage
  },
};
</script>,

<style lang="css" scoped>

@media only screen and (max-width: 390px) {
  .nav-container {
    grid-template-columns: 1fr;
    padding: 20px;
    width: 100%;
    margin: 0px;
  }
}

@media only screen and (min-width: 768px) {
  .nav-container {
    grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-template-areas: 
    "header header header header"
    "sidebar content content content"
    "footer footer footer footer";
    padding: 10px;
    width: 100%;
  }
}

.next-steps .fa-link {
    margin-right: 5px;
}

body {
  display: grid;
  
}
</style>
