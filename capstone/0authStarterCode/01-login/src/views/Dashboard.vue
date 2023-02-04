<template>
  <div class="nav-container">
    <!-- <hero /> -->
    <!-- <hr /> -->
    <main>
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

export default {
  name: "home-view",
  setup() {
  const auth0 = useAuth0()
  //axios.post('http://localhost:9000/user', { email: '1@email.com' } )
  axios.post('http://localhost:9000/user', { email: auth0.user.value.email} )

      axios.get(`http://localhost:9000/user?email=${auth0.user.value.email}`)
      .then(response => {
      const { ismanager, isactivated } = response.data;
      console.log(response.data)
      console.log(`isManager: ${ismanager}`);
      console.log(`isActivated: ${isactivated}`);
      })
      .catch(error => {
      console.error(error);
      });

  },
  components: {
    //Hero,
    //HomeContent,
    projTile,
    TaskTile
  },
};
</script>

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
