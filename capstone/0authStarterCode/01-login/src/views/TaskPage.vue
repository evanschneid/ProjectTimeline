<template>
  <div class="nav-container">
    <div class="logo-container">
      <logo-image />
    </div>
      <add-task/>
        <v-col
          cols="12"
          sm="6"
          class="pyx-1 text-center">
          <v-btn-toggle v-model="timeFilter">
            <v-btn>All</v-btn>
            <v-btn>Today</v-btn>
            <v-btn>Week</v-btn>
            <v-btn>Done</v-btn>
          </v-btn-toggle>
        </v-col>
        <v-card>
          <v-card-title>
            Tasks
          </v-card-title>
          <table>
            <thead>
              <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Due Date</th>
                <th>Active</th>
              </tr>
            </thead>
            <tbody>
              <tr
                v-for="task in filteredList"
                v-bind:key="task.id"
                v-bind:class="{ disabled: task.isCompleted===false}">
                <td>{{ task.taskTitle }}</td>
                <td>{{ task.taskDescription }}</td>
                <td>{{ task.taskDueDate }}</td>
                <td>
                  <button  v-on:click='flipStatus(task.id)' class="btnEComplete" v-if="!task.taskIsCompleted" >Complete</button>
                </td>
              </tr>
            </tbody>
          </table>
        </v-card>
  </div>
</template>

<script lang="ts">
import TaskTile from '../components/Dashboard/TaskTile.vue';
import { useAuth0 } from '@auth0/auth0-vue';
import LogoImage from '../components/LogoImage.vue';
import ServerService from '../services/ServerService.js';
import AddTask from '../components/AddTask.vue';
import Datepicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css';

export default {
  name: "home-view",
  data() {
    return {
      taskList: [],
      filter: {
        taskIsCompleted: false,
        DueDate:''
      },
      timeFilter: null
      
    }
  },
    methods: {
        flipStatus(id) {
            this.taskList.forEach( (task) => {
                if(task.id==id){
                    if(!task.taskIsCompleted){
                        task.taskIsCompleted=true;;
                    }else{
                        task.taskIsCompleted=false;
                    }
                }
            }
            )
        },
        dateDifference(today, due){
          let t1 = today.getTime();
          let t2 = due.getTime();
 
        return Math.floor((t2-t1)/(24*3600*1000));
        }
    },  
  computed:{
    filteredList() {
            let filteredTasks = this.taskList;
            if(!this.filter.taskIsCompleted && this.timeFilter===0){
                filteredTasks = filteredTasks.filter( (task) => 
                    !task.taskIsCompleted
                )
            }
            if(!this.filter.taskIsCompleted&&this.timeFilter===1){
              filteredTasks = filteredTasks.filter( (task) => 
                this.dateDifference(new Date(), new Date(task.taskDueDate))==0
              )
            }
            if(!this.filter.taskIsCompleted&&this.timeFilter===2){
              filteredTasks = filteredTasks.filter( (task) => 
                this.dateDifference(new Date(), new Date(task.taskDueDate))<=7 
                &&this.dateDifference(new Date(), new Date(task.taskDueDate))>0
                && !task.taskIsCompleted
              )
            }
            if(this.timeFilter===3){
              filteredTasks = filteredTasks.filter( (task) => 
                task.taskIsCompleted
              )
            }

            return filteredTasks;
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
    LogoImage,
    AddTask,
    Datepicker
  },
};
</script>,

<style>
  .nav-container {
    padding: 0 6% 6% 6%;
    display: flex;
    flex-direction: column;
    min-height: 100vh;
  }

  .logo-container {
    display: flex;
    justify-self: stretch;
    justify-content: space-around;
    flex-flow: row wrap;
    align-items: stretch;
    padding: 1em;
  }
  table {
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
    background-color: white;
    margin-top: 20px;
    width:100%
  }
  th {
    text-transform: uppercase;
    font-size: 12px;
    padding: 10px;
  }
  td {
    padding: 10px;
    font-size: 11px
  }
  .btnEComplete {
  margin-right: 5px;
  background-color: #335974;
  color: white;
  border-color: black;
  border-radius: 5px;
  padding: 5px;;
  }
</style>