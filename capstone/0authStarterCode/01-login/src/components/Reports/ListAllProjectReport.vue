<template>
  <v-card>
    <v-card-title>
        Time Reports
        <v-spacer></v-spacer>
        <v-text-field
            v-model="search"
            append-icon="mdi-magnify"
            label="Search"
            single-line
            hide-details
    ></v-text-field>
    </v-card-title>
    <v-table :search="search">
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
            v-for="item in worklogs"
            :key="item.user"
            >
            <td>{{ item.id }}</td>
            <td>{{ item.project }}</td>
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
    data () {
      return {
        search: '',
        worklogs: [],
      }
    },
    created() {
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
    }
}
</script>
<style>

</style>