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
            <td>{{ item.user }}</td>
            <td>{{ item.project }}</td>
            <td>{{ item.hours }}</td>
            </tr>
        </tbody>
        </template>
    </v-table>
  </v-card>
</template>

<script>
export default {
    data () {
      return {
        searh: '',
        worklogs: [
          {
            user: 'Manager 1',
            project: 'Project 1',
            hours: 15
          },
          {
            user: 'Manager 1',
            project: 'Project 2',
            hours: 15
          },
          {
            user: 'Manager 1',
            project: 'Project 3',
            hours: 10
          },
          {
            user: 'User 1',
            project: 'Project 1',
            hours: 35
          },
          {
            user: 'User 1',
            project: 'Project 3',
            hours: 5
          },
          {
            user: 'User 2',
            project: 'Project 2',
            hours: 20
          },
          {
            user: 'User 2',
            project: 'Project 3',
            hours: 20
          },
          {
            user: 'User 3',
            project: 'Project 1',
            hours: 40
          },
          {
            user: 'User 4',
            project: 'Project 1',
            hours: 10
          },
          {
            user: 'User 4',
            project: 'Project 2',
            hours: 20
          },
          {
            user: 'User 4',
            project: 'Project 3',
            hours: 10
          }
        ],
      }
    },
}
</script>

<style>

</style>