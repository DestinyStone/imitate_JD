import Vue from 'vue'
import Vuex from 'vuex'
import {getPmsBaseAttrInfo, getPmsBaseCataLog1, getPmsBaseCataLog2, getPmsBaseCataLog3} from "../network/item/itemApi";

Vue.use(Vuex)

let store = new Vuex.Store({
  state: {
    currentPath:null,
    tagHintsCatalog: {"一级分类": [], "二级分类": [], "三级分类": []},
    pmsBaseAttrInfoList: null
  },
  mutations: {
    setCurrentPath(state, currentPath) {
      state.currentPath = currentPath;
    },
    tagHintsCatalog(state, data) {
      state.tagHintsCatalog[data.type] = data.catalog;
    },
    setPmsBaseAttrInfoList(state, pmsBaseAttrInfoList) {
      state.pmsBaseAttrInfoList = pmsBaseAttrInfoList;
    }
  },
  getters: {

  },
  actions: {
    async getPmsBaseCataLog(state, data) {
      if (data.tagHint == "一级分类") {
        const responseData = await getPmsBaseCataLog1();
        state.commit("tagHintsCatalog", {"catalog": responseData.data.responseMessage, "type":data.tagHint});
      }

      if (data.tagHint == "二级分类") {
        const responseData = await getPmsBaseCataLog2(data.catalogId);
        state.commit("tagHintsCatalog", {"catalog": responseData.data.responseMessage, "type":data.tagHint});
      }

      if (data.tagHint == "三级分类") {
        const responseData = await getPmsBaseCataLog3(data.catalogId);
        state.commit("tagHintsCatalog", {"catalog": responseData.data.responseMessage, "type":data.tagHint});
      }
    },
    async getPmsBaseAttrInfoList(state, catalog3Id) {
      const responseData = await getPmsBaseAttrInfo(catalog3Id);
      state.commit("setPmsBaseAttrInfoList", responseData.responseMessage);
    }
  },
  models: {

  }
});

export default store;
