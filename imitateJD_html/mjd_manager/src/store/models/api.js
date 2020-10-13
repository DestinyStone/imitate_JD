import vueCookie from "vue-cookie"

const api = {
  namespaced: true,
  state:{
    currentPaths:vueCookie.get("currentPaths").split(",")
  },
  mutations: {
    setCurrentPath(state, currentPath) {
      state.currentPaths = [];
      this.commit('api/addCurrentPath', currentPath);
    },
    addCurrentPath(state, currentPath) {
      state.currentPaths.push(currentPath);
      this.commit('api/setCurrentPathCookie');
    },
    popCurrentPath(state) {
      state.currentPaths.pop();
      this.commit('api/setCurrentPathCookie');
    },
    setCurrentPathCookie(state) {
      vueCookie.set("currentPaths", state.currentPaths);
    }
  },
  getters: {
    getCurrentPath(state) {
      let currentPath = "";
      for(let i = 0; i < state.currentPaths.length; i++) {
        i == state.currentPaths.length - 1 ? currentPath += state.currentPaths[i] : currentPath += state.currentPaths[i] + " > ";
      }
      return currentPath;
    }
  }
};

export default api;
