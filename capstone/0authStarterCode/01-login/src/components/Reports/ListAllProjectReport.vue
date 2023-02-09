<template>
<div>
  <v-card>
    <v-card-title>
        Time Reports
    <v-spacer></v-spacer>
    <Datepicker class="calender" v-model="date" range :partial-range="false" />

    <v-text-field
        class="searchBar"
        v-model="search"
        label="Search Projects..."
        single-line
        hide-details>
    </v-text-field>
  </v-card-title>
  <v-table>
    <template v-slot:default>
    <thead>
        <tr>
        <th class="text-left">User</th>
        <th class="text-left">Project Name</th>
        <th class="text-left">Total Hours</th>
        </tr>
    </thead>
    <tbody>

        <tr
        v-for="(item, i) in filteredWorkLogs"
        :key="i">
        <td v-on:click="clickRow(item)">{{ item.userId }}</td>
        <td v-on:click="clickRow(item)">{{ item.projectTitle }}</td>
        <td v-on:click="clickRow(item)">{{ (item.totalTime/60).toFixed(2) }} hours</td>
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
    clickRow(item) {
      // navigate to a singleProjectTimeReport, passing the required parameters
      this.$router.push({ name: 'singleProjectTimeReport', params: { userId: item.userId, projectId: item.projectId } });
    }
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
                // look into a way to add months and days to get the closest comparison possible since it is only dates currently
              });
        }
        if(this.worklogs.projectTitle != "") {
          curatedLogs = curatedLogs.filter(item => {
            return item.projectTitle.toLowerCase().indexOf(this.search.toLowerCase()) > -1
          });
        }     
        return curatedLogs;
    },
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