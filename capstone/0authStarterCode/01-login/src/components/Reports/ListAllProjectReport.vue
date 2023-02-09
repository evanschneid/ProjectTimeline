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
        <td v-on:click="clickRow(item)">{{ item.userid }}</td>
        <td v-on:click="clickRow(item)">{{ item.projecttitle }}</td>
        <td v-on:click="clickRow(item)">{{ (item.totaltime/60).toFixed(2) }} hours</td>
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
        userid: '',
        clockin: '',
        clockout: '',
        projectid: '',
        totaltime: '',
        addedcomment: '',
        projecttitle: ''
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
      this.$router.push({ name: 'singleProjectTimeReport', params: { userid: item.userid, projectid: item.projectid } });
    }
  },
  computed: {
    filteredWorkLogs() {
        let curatedLogs = this.worklogs;

        if(this.date != undefined) {
          curatedLogs =  curatedLogs.filter(
              (item) => {
                console.log(typeof String(this.date[0]))
                console.log(typeof item.clockin)
                console.log(this.date[0].getFullYear() + "" + (this.date[0].getMonth()+1) + "" + this.date[0].getDate())
                let dateFromPicker = String(this.date[0].getFullYear());
                console.log(`Comparison:' + ${dateFromPicker} + " " + ${item.clockin} + " " + ${dateFromPicker < item.clockin} `);
                return dateFromPicker < item.clockin
                // look into a way to add months and days to get the closest comparison possible since it is only dates currently
              });
        }
        if(this.worklogs.projecttitle != "") {
          curatedLogs = curatedLogs.filter(item => {
            return item.projecttitle.toLowerCase().indexOf(this.search.toLowerCase()) > -1
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