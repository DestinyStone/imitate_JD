<template>
    <div id="index-subject-main">
        <div @click="test"></div>
        <div id="current-path">{{this.getCurrentPath}}</div>
        <img id="user-head"/>
    </div>
</template>

<script>
  import {mapActions, mapGetters, mapMutations, mapState} from "vuex";

  export default {
    name: "IndexSubjectMain",
    data() {
      return{
      }
    },
    methods: {
      test() {
        console.log(this.$store.state.getCurrentPath)
      }
    },
    computed: {
    //   ...mapState('api', {
    //     state: state => state
    //   }),
      ...mapGetters('api', ['getCurrentPath'])
    }
  }
</script>

<style scoped>
    #index-subject-main{
        box-sizing: padding-box;
        border-bottom: 1px solid #e6e6e6;
    }
    #index-subject-main{
        position: relative;
    }
    #current-path{
        font-family: "PingFang SC";
        box-sizing: padding-box;
        padding-top: 15px;
        padding-left: 15px;
    }
    #user-head {
        width: 50px;
        height: 50px;
        position: absolute;
        right: 10px;
        top: 0;
        cursor: pointer;
    }
</style>
