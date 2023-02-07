<template>
  <v-card>
    <v-card-title>
        Time Reports
        <v-spacer></v-spacer>

    <v-text-field
        v-model="search"
        append-icon="fa-house"
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
        v-for="(item, i) in filteredWorklogs"
        :key="i"
        >
        <td>{{ item.id }}</td>
        <td>{{ item.projectTitle }}</td>
        <td>{{ item.totalTime }}</td>
        </tr>
        
    </tbody>
    </template>
</v-table>
  </v-card>
</template>
<script>
import ServerService from '../../services/ServerService'
export default {
  name: "worklogReports",
  data() {
    return {
      worklogs:[], 
      search: ""
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
  computed: {
    filteredWorklogs() {
      return this.worklogs.filter(item => {
        return item.projectTitle.toLowerCase().indexOf(this.search.toLowerCase()) > -1
      });
    }
  }
}
</script>
<style>

</style>