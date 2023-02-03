<template>
    <div>
        <div>
            <button class="homeBtn"><font-awesome-icon icon="fa-list" size="2x" /></button>
        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style>
@media only screen and (max-width: 767px){
    .nav-container {
        background-color: white;
        overflow: hidden;
        position: sticky;
        bottom: 0;
        width: 100%;
        
    }

    .homeBtn {
        background-color: white;
        height: 4em;
        width: 100%;
        border-radius: 10px;
    }


}
</style>