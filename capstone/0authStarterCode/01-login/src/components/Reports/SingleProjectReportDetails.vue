<template>
<div class="nav-container">
    <v-card>
        <v-card-title>
            {{ worklogs.projectTitle }}
            <v-spacer></v-spacer>
            
            <Datepicker class="calender" v-model="date" range :partial-range="false" />
            <div class="timer">
                <timer-button />
            </div>
            <v-text-field
                class="seachBar"
                v-model="search"
                label="Search Date..."
                single-line
                hide-details>
            </v-text-field>
        </v-card-title>
        <v-table>
            <template v-slot:default>
            <thead>
                <tr>
                <th class="text-left">Start Time</th>
                <th class="text-left">End Time</th>
                <th class="text-left">Total Hours</th>
                </tr>
            </thead>
            <tbody>
                <tr
                v-for="(item, i) in filteredWorklogs"
                :key="i">
                <td>{{ item.clockIn }}</td>
                <td>{{ item.clockOut }}</td>
                <td>{{ item.totalTime/60 }} hours</td>
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
import TimerButton from '../../components/TimerButton.vue';
import ServerService from '../../services/ServerService'

export default {
    components: {
        Datepicker,
        TimerButton
    },
    data() {
        const date = ref();

        return {
        date,
        worklogs:[], 
        search: "",
        }
    },
    created () {
        const userReport = { userId: this.worklogs.userId, projectid: this.worklogs.projectid };
        ServerService.getAllReportsForUserByProjectId(1,1)
        // .then(response => {
        // if (response.data !== undefined) {
        //     this.worklogs = response.data; 
        //     console.log(response.data)
        // } else {
        //     console.log("No Reports");
        // }
        // })
        // .catch(error => {
        //     console.error(error);
        // });
    },
}
</script>

<style>
.timer {

}
.calender {
    margin: 1em;
}

.searchBar {
    border: black;
}
</style>