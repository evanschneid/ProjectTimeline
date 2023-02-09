<template>

  <div>
    <p class="stop-watch" style="font-family: -apple-system,system-ui,'Segoe UI',Helvetica,Arial,sans-serif,'Apple Color Emoji','Segoe UI Emoji';" v-if="started">{{leadingZero(hours)}} : {{ leadingZero(minutes)}} : {{ leadingZero(seconds) }}</p>
    <!-- v-if added if we want to have the timer running on top of the button-->
    <v-btn style="background-color: #335974; color: white" @click="startTimer" v-if ="!started">Start</v-btn>
    <!-- Stop can be used as a break for the user, does not reset timer, just stops so the user can do non project related things -->
    <v-btn  style="background-color: #D69510; color: #fff" @click="stopTimer" v-else>Pause</v-btn>
    <!-- Submit resets the timer. currently has no function other than resetting the timer to 0:0:0, but can be used to pop up an input later on  that will keep a record of the length
    and then the user can add a description about what work was done during the length of time. -->
    <v-dialog v-model="dialog" max-width= "600">
      <template v-slot:activator="{ on, attrs }">
      <v-btn v-bind="attrs" v-on="on" style="background-color: #78B2C6; color: #fff;" @click="submitTimer">Submit</v-btn> <!-- --> 
      </template>
      <v-card>
        <v-card-title>
          <h2> Add New Work Log</h2>
        </v-card-title>
        <v-card-text>
          Time Started: {{this.workLog.clockin}}
        </v-card-text>
        <v-card-text>
          Time Ended: {{this.workLog.clockout}}
        </v-card-text>
        <v-card-text>
          Time Worked: {{this.workLog.totaltime}} hours
        </v-card-text>
        <!-- <v-card-text>
          <v-form class="px-3">
              <v-textarea label="Comments" v-model="workLog.addedComment"></v-textarea>
          </v-form>
        </v-card-text> -->
        <v-btn
          class="my-4 mx-4"
          @click="addLog()">Add</v-btn>
      </v-card>
    
    
    </v-dialog> 
    
 </div>

  
</template>

<script>
import workLogService from "../services/ServerService.js";

export default {
  name: 'create-workLog',
  props: ["projectid", "userid"],
  data() {
    return {
      //Initial time values, timer, started boolean, timeLog
      dialog: false, 
      hours: 0,  
      minutes: 0,
      seconds: 0,
      timer: null,
      started: false,
      workLog : 
      {
        clockin: '',
        clockout: '',
        totaltime:0,
        addedcomment: '',
        projectid: this.projectid,
        userid: this.userid,
      }
    };
  },
  methods: {
    //method used to start the timer when a user presses the button
    startTimer() {
      console.log('userId:' + this.userid)
      console.log('projectId:' + this.projectid)
      //started boolean changed to true in order to use v-if in template section
      this.workLog.clockin = this.getTime();
      this.started = true;  
      //set interval used to repeatedly run the function in 1000 milisecond intervals
      this.timer = setInterval(() => {
        //once the seconds goes to 60, the minutes increments and the seconds is set to 0 again
        if (this.seconds === 59) {
          this.minutes++;
          this.seconds = 0;
          //once the minutes goes to 60, the hours increments and the minutes and seconds is set to 0 again
          if (this.minutes===60){
            this.minutes=0;
            this.seconds ==0;
            this.hours++;
            } 
        }else{
            //if the conditions arent mean, only the seconds increment
            this.seconds++;
        }
      }, 1000);
    },
    // method is used when the button is pressed again to pause the timer
    stopTimer() {
      //changes the started boolean to false in order to use the v-else statement and change the styling of the button
      this.started = false; 
      //stops the timer from continually running
      clearInterval(this.timer);
    },
    // resetTimer method used to zero out the timer and stop the intervals
    //all time variables are set back to 0 and a timeLog that saves the length time worked
    //to the nearest quater of an hour
    submitTimer() {
      this.workLog.clockout = this.getTime();
      this.started = false;
      this.dialog = true;
      clearInterval(this.timer);
      this.workLog.totaltime = this.hours + (this.minutes - (this.minutes % 15) + (this.minutes % 15 >= 8 ? 15 : 0))/60;
      this.hours = 0;
      this.minutes = 0;
      this.seconds = 0;


    },
    //when the time values are less than 10, there is a leading 0, just as a clock
     leadingZero(value) {
      return value < 10 ? `0${value}` : value;
    },
    getTime() {
      return new Date().toISOString();
      // return new Date().toLocaleString();
    },
    addLog(){
      workLogService.createReport(this.workLog)
      .then(response => {
        console.log(response.data);
        this.dialog = false;
        // this is not working since a page refresh goes back to our home apge everytime. look into this a little bit
        // this.$router.go(0)
        this.$router.push({ name: "singleProjectTimeReport", params: { userid: this.$route.params.userid, projectid: this.$route.params.projectid }});
      })
      .catch(error => {
        console.error(error);
      });
    }
  },
};
</script>

<style>
.stop-watch {
    display: flex;
    justify-self: stretch;
    justify-content: space-around;
    flex-flow: row wrap;
    align-items: stretch;
    padding: 1em;
}
</style>
