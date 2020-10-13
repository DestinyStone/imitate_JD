import Vuex from "vuex"
import api from "./models/api"
import Vue from "vue"
import home from "./models/home"

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    api,
    home
  }
});

export default store;
