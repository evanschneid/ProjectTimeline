<template>
  <div>  <!-- body & header -->
      <v-card class="taskTile" v-for="task in taskCard" v-bind:key="task"> <!-- need to add v-on:click -->
        <v-card-text>
          <p>Task #: {{taskCard.taskID}}</p>
          <h2>{{taskCard.taskTitle}}</h2>
          <p>Due date: {{taskCard.taskDueDate}}</p>
        </v-card-text>
      </v-card>

      <form>
        {{taskCard}}<br>
        Task No.: <input type="text" v-model="taskCard.taskID" />
        Task Title.: <input type="text" v-model="taskCard.taskTitle" />
        Due Date: <input type="text" v-model="taskCard.taskDueDate" />
      </form>
  </div>
</template>

<script>
// import service from './services/ServerService.js';

export default {
  name: "taskTile",
  data() {
    return {
      taskCard:{}      
    }
  },
  // created () {
  //   service.getAllProjects().then(
  //     (response) => {
  //       this.taskCard = response.data;
  //     }
  //   )
  // }
}
</script>

<style>

.taskTile {
  display: flex;
  flex-wrap: wrap;
  padding: 10px;
  margin: 5px;
  border: 5px;
  border-style: solid;
  border-color: #335974;
  border-radius: 10%;
  width: 150px;
  height: 150px;
  background-color: #F2D678;
  color: #335974;
}

#titleText {
  color: #335974;
}

</style>