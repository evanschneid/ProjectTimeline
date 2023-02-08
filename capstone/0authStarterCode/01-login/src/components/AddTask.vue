<template>

  <div>
    
    <v-dialog v-model="dialog" max-width= "600">
      <template v-slot:activator="{ on, attrs }">
      <v-btn v-bind="attrs" v-on="on" style="background-color: #335974; color: #fff;" @click="dialog=true">Add Task</v-btn> <!-- --> 
      </template>
      <v-card>
 
        <v-card-text>
          <v-form class="px-3">
            <v-text-field label="Task Title" v-model="task.taskTitle"/>
            <v-textarea label="Task Desciption" v-model="task.taskDescription"></v-textarea>
            <v-menu
                ref="menu1"
                v-model="menu1"
                :close-on-content-click="false"
                :return-value.sync="task.taskDueDate"
                transition="scale-transition"
                offset-y
                min-width="auto"
            >
                <template v-slot:activator="{ on, attrs }">
                    <Datepicker
                    placeholder="Due Date"
                    v-model="task.taskDueDate"
                    @input="menu1=false"
                    v-bind="attrs" v-on="on"
                 ></Datepicker>
                </template>
                
            </v-menu>

             <v-btn
                class="mt-4"
                @click="submit">Add</v-btn>
          </v-form>

        </v-card-text>
      </v-card>
    
              
    </v-dialog> 
 </div>


</template>

<script>
import ServerService from '../services/ServerService';
import Datepicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css';
export default {
  name: 'create-task',
  //props: ["projectId"],
  data() {
    return {
      //Initial time values, timer, started boolean, timeLog
      task: {
          taskTitle: '',
          taskDescription: '',
          taskDueDate: '',
    
      },
      menu1: false,
      dialog: false,

    };
  },
  methods: {
      submit(){
        ServerService.addTask(this.task);
        console.log(this.task);
        this.task.taskTitle='';
        this.task.taskDescription='';
        this.task.taskDueDate=''
      },
  },
  computed: {
    dateFormatter(){
        const months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
        let dateArray = this.task.taskDueDate.split(' ').slice(1,4);
        return ""+dateArray[2]+ "-" + dateArray[1] + "-" + (months.indexOf(dateArray[0])+1)
      }
  }
};
</script>

<style>
</style>