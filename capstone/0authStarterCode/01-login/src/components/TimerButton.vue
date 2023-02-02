<template>
  <div>
    <p class="stop-watch">{{leadingZero(hours)}} : {{ leadingZero(minutes)}} : {{ leadingZero(seconds) }}</p>
    <!-- v-if added if we want to have the timer running on top of the button-->
    <button class= "start" @click="startTimer" v-if ="!started">Start</button>
    <!-- Stop can be used as a break for the user, does not reset timer, just stops so the user can do non project related things -->
    <button class= "stop" @click="stopTimer" v-else>Pause</button>
    <!-- Submit resets the timer. currently has no function other than resetting the timer to 0:0:0, but can be used to pop up an input later on  that will keep a record of the length
    and then the user can add a description about what work was done during the length of time. -->
    <button class = "submit" @click="submitTimer">Submit</button>

  </div>
</template>

<script>
export default {
  data() {
    return {
      //Initial time values, timer, started boolean, timeLog
      hours: 0,  
      minutes: 0,
      seconds: 0,
      timer: null,
      started: false,
      totalTime: 0
    };
  },
  methods: {
    //method used to start the timer when a user presses the button
    startTimer() {
      //started boolean changed to true in order to use v-if in template section
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
      this.started = false;
      clearInterval(this.timer);
      this.totalTime = this.hours + (this.minutes - (this.minutes % 15) + (this.minutes % 15 >= 8 ? 15 : 0))/60;
      this.hours = 0;
      this.minutes = 0;
      this.seconds = 0;
    },
    //when the time values are less than 10, there is a leading 0, just as a clock
     leadingZero(value) {
      return value < 10 ? `0${value}` : value;
    }
  },
};
</script>

<style>

.start {
  appearance: none;
  background-color: #335974;
  border: 1px solid rgba(27, 31, 35, .15);
  border-radius: 6px;
  box-shadow: rgba(27, 31, 35, .1) 0 1px 0;
  box-sizing: border-box;
  color: #fff;
  cursor: pointer;
  display: inline-block;
  font-family: -apple-system,system-ui,"Segoe UI",Helvetica,Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji";
  font-size: 14px;
  font-weight: 600;
  line-height: 20px;
  padding: 6px 16px;
  position: relative;
  text-align: center;
  text-decoration: none;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  vertical-align: middle;
  white-space: nowrap;
}
.stop {
  appearance: none;
  background-color: #D69510;
  border: 1px solid rgba(27, 31, 35, .15);
  border-radius: 6px;
  box-shadow: rgba(27, 31, 35, .1) 0 1px 0;
  box-sizing: border-box;
  color: #fff;
  cursor: pointer;
  display: inline-block;
  font-family: -apple-system,system-ui,"Segoe UI",Helvetica,Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji";
  font-size: 14px;
  font-weight: 600;
  line-height: 20px;
  padding: 6px 16px;
  position: relative;
  text-align: center;
  text-decoration: none;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  vertical-align: middle;
  white-space: nowrap;
}
.submit {
  appearance: none;
  background-color: #78B2C6;
  border: 1px solid rgba(27, 31, 35, .15);
  border-radius: 6px;
  box-shadow: rgba(27, 31, 35, .1) 0 1px 0;
  box-sizing: border-box;
  color: #fff;
  cursor: pointer;
  display: inline-block;
  font-family: -apple-system,system-ui,"Segoe UI",Helvetica,Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji";
  font-size: 14px;
  font-weight: 600;
  line-height: 20px;
  padding: 6px 16px;
  position: relative;
  text-align: center;
  text-decoration: none;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  vertical-align: middle;
  white-space: nowrap;
}
.stop-watch {
    font-family: -apple-system,system-ui,"Segoe UI",Helvetica,Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji";
}




</style>