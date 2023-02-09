<template>
  <div>
    <div class="tile-container">
      <router-link v-bind:to="{name: 'tasks', params: {id: task.id}}" v-for="task in filteredList" v-bind:key="task.id">
      <div class="taskTile" >
       <!-- need to add v-on:click -->
            <h4>{{task.tasktitle}}</h4>
            <p>Due date: {{ new Date(task.taskduedate).toLocaleDateString() }}</p>
      </div>
      </router-link>
    </div>
      <!-- <form>
        {{taskCard}}<br>
        Task No.: <input type="text" v-model="taskCard.taskID" /><br>
        Task Title.: <input type="text" v-model="taskCard.taskTitle" /><br>
        Due Date: <input type="text" v-model="taskCard.taskDueDate" />
      </form> -->
  </div>
</template>

<script>
import service from '../../services/ServerService.js';

export default {
  name: "taskTile",
  props: ['sort'],
  data() {
    return {
      taskCard:[],
      
    }
  },
  created () {
    service.getAllTasks().then(
      (response) => {
        this.taskCard = response.data;
        console.log(response.data);
      }
    )
  },
    computed:{
    filteredList() {
            let filteredTasks = this.taskCard;
            if(this.sort===1){
              filteredTasks = filteredTasks.filter( (task) => 
                 !task.tasksscompleted

              )
            }
            if(this.sort===2){
              filteredTasks = filteredTasks.filter( (task) => 
                task.tasksscompleted
              )
            }

            return filteredTasks;
        }
  }
}
</script>

<style>

.tile-container {
  display: flex;
  flex-wrap: nowrap;
  overflow-x: auto;
}

.tile-container::-webkit-scrollbar {
  display: none;
} 

.taskTile {
  display: inline-flex;
  flex-wrap: wrap;
  padding: 10px;
  margin: 5px;
  border: 5px;
  border-style: solid;
  border-color: #335974;
  border-radius: 10%;
  flex: 0 0 auto;
  width: 150px;
  height: 150px;
  background-color: #F2D678;
  color: #335974;
}

#titleText {
  color: #335974;
}

</style>