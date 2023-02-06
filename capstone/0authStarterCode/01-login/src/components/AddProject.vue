<template>

  <div>
    
    <v-dialog v-model="dialog" max-width= "600">
      <template v-slot:activator="{ on, attrs }">
      <v-btn v-bind="attrs" v-on="on" style="background-color: #78B2C6; color: #fff;" @click="submitTimer">Add Project</v-btn> <!-- --> 
      </template>
      <v-card>
 
        <v-card-text>
          <v-form class="px-3">
            <v-text-field label="Untitled Project" v-model="project.projectTitle"/>
            <v-file-input label="Project Image" v-model="selectedImage" @change="readImage"></v-file-input>
            <img  style="max-width: 50%;
                max-height: 50%;
                object-fit: contain;" v-if="imageData" :src="imageData"/>
            <v-textarea label="Project Descripion" v-model="project.projectDescription"></v-textarea>
            <v-menu
                ref="menu"
                v-model="menu1"
                :close-on-content-click="false"
                :return-value.sync="date"
                transition="scale-transition"
                offset-y
                min-width="auto"
            >
                <template v-slot:activator="{ on, attrs }">
                    <v-text-field
                        v-model="project.projectDeadline"
                        label="Deadline"
                        hint="MM/DD/YYYY format"
                        persistent-hint
                        prepend-icon="mdi-calendar" v-bind="attrs" v-on="on">
                    </v-text-field>
                </template>
                <v-date-picker
                    v-model="project.projectDeadline"
                    @input="menu1= false"
                 ></v-date-picker>
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


export default {
  name: 'create-project',
  //props: ["projectId"],
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
      imageData: null
    };
  },
  methods: {
    readImage() {
      let reader = new FileReader();
      reader.readAsDataURL(this.selectedImage);
      reader.onload = (e) => {
        this.imageData = e.target.result;
      };
    }
  
    
  },
};
</script>

<style>
</style>