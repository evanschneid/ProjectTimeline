<template>
  <div>
        <div>
            <router-link v-bind:to="{name: 'dashboard'}"><button class="homeBtn"><font-awesome-icon icon="fa-house" size="3x" /></button></router-link>
        </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>

    .nav-container {
        background-color: white;
        /* overflow: hidden; */
        position: sticky;
        bottom: 0;
        width: 100%;
        
    }

    .homeBtn {
        background-color: white;
        height: 4em;
        width: 100%;
        border-radius: 10px;
        color: black;
    }



</style>