<template>


  <div>
    <v-dialog v-model="dialog" max-width= "600">
      <template v-slot:activator="{ on, attrs }">
      <v-btn v-bind="attrs" v-on="on" style="background-color: #78B2C6; color: #fff;" @click="dialog=true">Add Project</v-btn> <!-- -->
      </template>
      <v-card>
 
        <v-card-text>
          <v-form class="px-3">
            <v-text-field label="Untitled Project" v-model="project.projectTitle"/>
            <!-- Add image icon if needed-->
            <v-file-input label="Project Image" v-model="selectedImage" @change="readImage"></v-file-input>
            <img style="max-width: 50%;
                max-height: 50%;
                object-fit: contain;" v-if="imageData" :src="imageData"/>
            <v-textarea label="Project Descripion" v-model="project.projectDescription"></v-textarea>
            <v-menu
                ref="menu1"
                v-model="menu1"
                :close-on-content-click="false"
                transition="scale-transition"
                offset-y
                min-width="auto"
            >
                <template v-slot:activator="{ on, attrs }">
                  <!-- Add calendar icon if needed-->
                    <Datepicker
                    class="date-picker-style"
                    placeholder="Deadline"
                    v-model="project.projectDeadline"
                    @input="project.projectDeadline=dateFormat(project.projectDeadline)"
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


import Datepicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css'


export default {
  name: 'create-project',
   components: {
    Datepicker
  },


  data() {
    return {
      //Initial time values, timer, started boolean, timeLog
      project: {
          projectTitle: '',
          projectDescription: '',
          projectImage: '',
          projectDeadline: null
      },
      menu1: false,
      selectedImage: null,
      imageData: null,
      dialog:false
    };
  },
  methods: {
    readImage() {
      let reader = new FileReader();
      reader.readAsDataURL(this.selectedImage);
      reader.onload = (e) => {
        this.imageData = e.target.result;
      };
    },
    dateFormat(dateAndTime){
      this.menu1=false;
      let date = dateAndTime.split(' ');
      let dateArray = date.split('/');
      return dateArray[2].concat(' ', dateArray[1].concat(' ', dateArray[0]));

    }

  },
};
</script>


<style>
.date-picker-style{
  color:#90A4AE
}
</style>
