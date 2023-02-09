<template>
<div>
    <v-card>
        <v-card-title>
            title: 
            <div>{{ project.projectTitle }}</div>
            
            <!-- <v-spacer></v-spacer> -->
            
            <!-- <Datepicker class="calender" v-model="date" range :partial-range="false" /> -->
            <div class="timer">
                <timer-button v-bind:projectId="this.$route.params.projectId" :userId="this.$route.params.userId" />
            </div>

        </v-card-title>
        <v-table>
            <template v-slot:default>
            <thead>
                <tr>
                <th class="text-left">Date</th>
                <th class="text-left">Start Time</th>
                <th class="text-left">End Time</th>
                <th class="text-left">Total Hours</th>
                </tr>
            </thead>
            <tbody>
                <tr
                v-for="(item, i) in worklogs"
                :key="i">
                <td>{{ new Date(item.clockOut).toLocaleDateString() }}</td>
                <td>{{ new Date(item.clockIn).toLocaleTimeString() }}</td>
                <td>{{ new Date(item.clockOut).toLocaleTimeString() }}</td>
                <td>{{ (item.totalTime/60).toFixed(2) }} hours</td>
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
    // props: ["projectTitle"],
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
        project: {
            projectTitle: ''
        }
        }
    },
    created () {
        console.log({userId: this.$route.params.userId, projectid: this.$route.params.projectId})
        ServerService.getAllReportsForUserByProjectId(this.$route.params.userId, this.$route.params.projectId).then(response => {
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
        ServerService.getProjectByProjectId(this.$route.params.projectId).then(response => {
        if (response.data !== undefined) {
            let test = response.data;
            this.project = test; 
            console.log(response.data)
        } else {
            console.log("No Reports");
        }
        })
        .catch(error => {
            console.error(error);
        });
    },

}
</script>

<style>
.timer {
    display: flex;
    justify-self: stretch;
    justify-content: space-around;
    flex-flow: row wrap;
    align-items: stretch;
    padding: 1em;
}
.calender {
    margin: 1em;
}

.searchBar {
    border: black;
}
</style>