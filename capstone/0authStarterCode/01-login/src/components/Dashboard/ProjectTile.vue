<template>
  <div>
      <div class="projTile-container">
        <div class="projTile" 
        v-for="project in projCard" v-bind:key="project.projectid"> <!-- need to add v-on:click -->
            <h4>{{project.projectTitle}}</h4>
            <p>Due date: {{project.projectDueDate}}</p>
        </div>
      </div>
      <!-- <form>
        {{projCard}}<br>
        Proj No.: <input type="text" v-model="projCard.projectID" /><br>
        Proj Title.: <input type="text" v-model="projCard.projectTitle" /><br>
        Due Date: <input type="text" v-model="projCard.projectDueDate" />
      </form> -->
  </div>
</template>

<script>
import service from '../../services/ServerService.js'

export default {
  name: "projTile",
  data() {
    return {
      projCard:[] 
    }
  },
  created () {
    service.getAllProjects().then(
      (response) => {
        this.projCard = response.data;
        console.log(response.data);
      }
    )
  }
}
</script>

<style>

.projTile-container {
  display: flex;
  flex-wrap: nowrap;
  overflow-x: auto;
  
}

/* .projTile-container::-webkit-scrollbar {width: 0;} */


.projTile {
  display: inline-block;
  padding: 10px;
  margin: 5px;
  border: 5px;
  border-style: solid;
  border-color: #F2D678;
  border-radius: 10%;
  flex: 0 0 auto;
  width: 45%;
  height: 150px;
  background-color: #335974;
  color: #F2D678;
}



#titleText {
  color: #78B2C6;
}

</style>