<template>
<div>
  <v-card>
    <v-card-title>
        Time Reports
    <v-spacer></v-spacer>
        <!-- {{ date }}<br><br>
        <h3>Debug</h3>
        {{worklogs}}<br>
        <h3>Debug</h3>
        {{filteredWorkLogs2}} -->
    <Datepicker class="calender" v-model="date" range :partial-range="false" />

    <v-text-field
        class="searchBar"
        v-model="search"
        label="Search Projects..."
        single-line
        hide-details
    ></v-text-field>
  </v-card-title>
  <v-table>
    <template v-slot:default>
    <thead>
        <tr>
        <th class="text-left">
            User
        </th>
        <th class="text-left">
            Project Name
        </th>
        <th class="text-left">
            Total Hours
        </th>
        </tr>
    </thead>
    <tbody>
        <tr
        v-for="(item, i) in filteredWorkLogs"
        :key="i"
        >
        <td>{{ item.id }}</td>
        <td>{{ item.projectTitle }}</td>
        <td>{{ item.totalTime }} hours</td>
        </tr>
        
    </tbody>
    </template>
  </v-table>
  </v-card>
</div>
</template>

<script>
import { ref } from 'vue';
import Datepicker from '@vuepic/vue-datepicker';
import ServerService from '../../services/ServerService'

export default {

  // setup() {
  //       const date = ref(new Date());
  //       const format = (date)=> {return date.getDate()}

  //       return {date, format}
  // },
  name: "worklogReports",
  components: {
    Datepicker
  },
  data() {
    const date = ref();

    return {
      date,
      worklogs:[], 
      worklogFilter: {
        userId: '',
        clockIn: '',
        clockOut: '',
        projectID: '',
        totalTime: '',
        addedComment: '',
        projectTitle: ''
      },
      search: "",
    }
  },
  created () {
    ServerService.getAllReports().then(response => {
      if (response.data !== undefined) {
        this.worklogs = response.data; 
        console.log(response.data)
      } else {
        console.log("No Reports");
      }
    })
    .catch(error => {
      console.error(error);
    });
  },
  methods: {
    // dateFormat(dateAndTime){
    //   let date1 = dateAndTime[0].split('T');
    //   let date2 = dateAndTime[1].split('T');
    //   let dateArray1 = date1.split('-');
    //   let dateArray2 = date2.split('-');
    //   return date1[0].concat(' ', date2[0]));
    // },
  },
  
  computed: {

    filteredWorkLogs() {

        let curatedLogs = this.worklogs;

        if(this.date != undefined) {
          curatedLogs =  curatedLogs.filter(
              (item) => {
                console.log(typeof String(this.date[0]))
                console.log(typeof item.clockIn)
                console.log(this.date[0].getFullYear() + "" + (this.date[0].getMonth()+1) + "" + this.date[0].getDate())
                let dateFromPicker = String(this.date[0].getFullYear());
                console.log(`Comparison:' + ${dateFromPicker} + " " + ${item.clockIn} + " " + ${dateFromPicker < item.clockIn} `);
                return dateFromPicker < item.clockIn
                // return this.date[0].localeCompare(item.clockIn) < 0;
              });
        }
        if(this.worklogs.projectTitle != "") {
          curatedLogs = curatedLogs.filter(item => {
            return item.projectTitle.toLowerCase().indexOf(this.search.toLowerCase()) > -1
          });
        }     
        return curatedLogs;
    },
    // filteredWorklogs() {
    //   let filteredList = this.worklogs;

    //   if(this.worklogs.projectTitle != "") {
    //     filteredList.filter(item => {
    //       return item.projectTitle.toLowerCase().indexOf(this.search.toLowerCase()) > -1
    //       });
    //   }
    //   // this one might need to be removed since it is only good for managers techincally....
    //   if(this.worklogs.userId != "") {
    //     filteredList.filter(item => {
    //       return item.userId.toLowerCase().indexOf(this.search.toLowerCase()) > -1
    //       });
    //   }
      
    //   if(this.date != "") {
    //     filteredList.filter((item) => {
    //       return item.clockIn <= this.date[0] && item.clockOut >= this.date[1]
    //       });
    //   }
    //   return filteredList;
    // },
  }
}
</script>
<style>
  .calender {
    margin: 1em;
  }

  .searchBar {
    border: black;
  }
</style>