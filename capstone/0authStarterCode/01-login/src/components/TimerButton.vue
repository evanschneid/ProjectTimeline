<template>
  <div>
    <p class="stop-watch">{{hours}} : {{ minutes }} : {{ seconds }}</p>
    <!-- v-if added if we want to have the timer running on top of the button-->
    <button class= "start" @click="startTimer" v-if ="!started">Start</button>
    <!-- Stop can be used as a break for the user, does not reset timer, just stops so the user can do non project related things -->
    <button class= "stop" @click="stopTimer" v-else>Pause</button>
    <!-- Submit resets the timer. currently has no function other than resetting the timer to 0:0:0, but can be used to pop up an input later on  that will keep a record of the length
    and then the user can add a description about what work was done during the length of time. -->
    <button class = "submit" @click="resetTimer">Submit</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      hours: 0,  
      minutes: 0,
      seconds: 0,
      timer: null,
      started: false
    };
  },
  methods: {
    startTimer() {
      this.started = true;  
      this.timer = setInterval(() => {
        if (this.seconds === 59) {
          this.minutes++;
          this.seconds = 0;
          if (this.minutes===60){
            this.minutes=0;
            this.seconds ==0;
            this.hours++;
            } 
        }else{
            this.seconds++;
        }
        
        
      }, 1000);
    },
    stopTimer() {
      this.started = false;  
      clearInterval(this.timer);
    },
    resetTimer() {
      clearInterval(this.timer);
      this.hours = 0;
      this.minutes = 0;
      this.seconds = 0;
    },
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