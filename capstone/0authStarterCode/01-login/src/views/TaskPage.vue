<template>
  <div>
    <div class="logo-container">
      <logo-image />
    </div>
      <div>
      <div v-for="task in taskList" v-bind:key="task.id">
        <p>Task# {{task.id}}</p>
        <h3>{{task.taskTitle}}</h3>
        <p>{{task.taskDescription}}</p>
        <p>{{task.taskDueDate}}</p>
      </div> 
      </div>
  </div>
</template>

<script lang="ts">
import TaskTile from '../components/Dashboard/TaskTile.vue';
import { useAuth0 } from '@auth0/auth0-vue';
import LogoImage from '../components/LogoImage.vue';
import ServerService from '../services/ServerService.js';

export default {
  name: "home-view",

  data() {
    return {
      taskList: []
    }
  },

  created() {
      const auth0 = useAuth0()

      ServerService.verifyThroughEmail({ email: auth0.user.value.email})
      
      ServerService.getUserByEmail(`${auth0.user.value.email}`)
      .then(response => {
      const { ismanager, isactivated, userid } = response.data;
      if(response.data == null){
        window.location.reload();
      }
      
      console.log(response.data)
      console.log(`isManager: ${ismanager}`);
      console.log(`isActivated: ${isactivated}`);
      console.log(`userId: ${userid}`);
      
      if (!isactivated) {
        console.log("User is not activated, logging out");
        auth0.logout({ logoutParams: {
                returnTo: window.location.origin
                }})
      } 
      
      if (!ismanager) {
          
          //Get Tasks for User
          ServerService.getAllTasksByUserId(`${userid}`).then(response => {
          this.taskList = response.data; 
          console.log(response.data)
          })
          

      } else {
        
          //Get All Tasks
          console.log('Getting ALL Tasks')
          ServerService.getAllTasks().then(response => {
          this.taskList = response.data;
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
    TaskTile,
    LogoImage
  },
};
</script>,

<style>
  .logo-container {
    display: flex;
    justify-self: stretch;
    justify-content: space-around;
    flex-flow: row wrap;
    align-items: stretch;
    padding: 1em;
  }
</style>