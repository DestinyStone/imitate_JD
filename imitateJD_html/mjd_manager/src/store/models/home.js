import {
  getPmsBaseAttrInfo,
  getPmsBaseCataLog1,
  getPmsBaseCataLog2,
  getPmsBaseCataLog3
} from "../../network/item/itemApi";

const home = {
  namespaced: true,
  state: {
    tagHintsCatalog: {"一级分类": [], "二级分类": [], "三级分类": []},
    pmsBaseAttrInfoList: null
  },
  mutations: {
    tagHintsCatalog(state, data) {
      state.tagHintsCatalog[data.type] = data.catalog;
    },
    setPmsBaseAttrInfoList(state, pmsBaseAttrInfoList) {
      state.pmsBaseAttrInfoList = pmsBaseAttrInfoList;
    }
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
      state.commit("setPmsBaseAttrInfoList", responseData.data.responseMessage);
    }
  }
}

export default home;
