<template>
  <v-card>
    <v-card-title>
        Time Reports
        <v-spacer></v-spacer>
        <!-- <input type="text" v-model="search" placeholder="Search Project..." /> -->
        <!-- <div class="searchBar" v-for="item in filteredList" :key="item.user"></div> -->

        <v-row>
            <v-col
            cols="12"
            sm="6"
            >
            <v-date-picker
                v-model="dates"
                range
            ></v-date-picker>
            </v-col>
            <v-col
            cols="12"
            sm="6"
            >
            <v-text-field
                v-model="dateRangeText"
                label="Date range"
                prepend-icon="mdi-calendar"
                readonly
            ></v-text-field>
            model: {{ dates }}
            </v-col>
        </v-row>

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
            v-for="(item, i) in filteredProjectList"
            :key="i"
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
//   name: "worklogReports",
//   data() {
//     return {
//       worklogs:[] 
//     }
//   },
//   created () {
//     service.getAllworklogs().then(
//       (response) => {
//         this.worklogs = response.data;
//       }
//     )
//   }
    computed: {
        filteredProjectList() {
            // switch this to filter thru dates once we have date coming thru
            return this.worklogs.filter( item => {
                return item.project.toLowerCase().indexOf(this.search.toLowerCase()) > -1
            })
        },
        dateRangeText () {
            return this.dates.join(' ~ ')
        },
    },
    method: {
        datefilter() {
            const filterDate = {
                start_date: "",
                end_date: "",
            }
            const filteredItems = data.filter((item, index) => 
            item.start_date >= filterDate.start_date && item.end_date <= filterDate.end_date);
        }
    },


    data () {
      return {
        search: '',
        dates: ['2019-09-10', '2019-09-20'],
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