<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>

import ManagerLogin from "./views/login/ManagerLogin";
import Index from "./views/home/index";
import {mapMutations, mapState} from "vuex"
export default {
  name: 'App',
  components: {
    Index,
    ManagerLogin
  },
  computed: {
    ...mapState('api', {
      state: state => state
    })
  },
  methods: {
    ...mapMutations('api', ['setCurrentPath']),
    test() {
      this.setCurrentPath("33")
      console.log( this.state);
    }
  }
}
</script>

<style>
  @import "assets/css/base.css";
  @import url("../node_modules/element-ui/lib/theme-chalk/index.css");
  #app {
    position: relative;
  }
  html, body, #app{
    margin: 0;
    width: 100%;
    height: 100%;
    overflow: hidden;
  }
  ::-webkit-scrollbar {
    width: 10px;
    height: 10px;
  }
  ::-webkit-scrollbar-thumb {
    background-color: #a1a3a9;
    border-radius: 3px;
  }
</style>
