
/**
 * @author DestinyStone
 * @date 2020/10/11 00:29
 */

import itemRequest from "./itemRequest";

/**
 * @returns {*}
 * @description 获取一级分类
 */
export const getPmsBaseCataLog1 = () => itemRequest.get("/getPmsBaseCataLog1");

/**
 * @returns {*}
 * @description 获取二级分类
 */
export const getPmsBaseCataLog2 = (catalog1Id) => itemRequest.get(`/getPmsBaseCataLog2?catalog1Id=${catalog1Id}`);

/**
 * @returns {*}
 * @description 获取三级分类
 */
export const getPmsBaseCataLog3 = (catalog2Id) => itemRequest.get(`/getPmsBaseCataLog3?catalog2Id=${catalog2Id}`);

/**
 * @returns {*}
 * @description 获取平台属性
 */
export const getPmsBaseAttrInfo = (catalog3Id) => itemRequest.get(`/getPmsBaseAttrInfo?catalog3Id=${catalog3Id}`);

/**
 * @returns {*}
 * @description 更新一级分类
 */
export const updatePmsBaseCatalog1 = (catalog1Id, name) => itemRequest.get(`/updatePmsBaseCataLog1`, {
  params:{catalog1Id: catalog1Id, name: name}
}).catch(error => {});


/**
 * @returns {*}
 * @description 更新二级分类
 */
export const updatePmsBaseCatalog2 = (catalog2Id, name) => itemRequest.get(`/updatePmsBaseCataLog2`, {
  params:{catalog2Id: catalog2Id, name: name}
}).catch(error => {});


/**
 * @returns {*}
 * @description 更新三级分类
 */
export const updatePmsBaseCatalog3 = (catalog3Id, name) => itemRequest.get(`/updatePmsBaseCataLog3`, {
  params:{catalog3Id: catalog3Id, name: name}
}).catch(error => {});

/**
 * @returns {*}
 * @description 删除一级分类
 */
export const deletePmsBaseCatalog1 = (catalog1Id) => itemRequest.get("/deletePmsBaseCataLog1", {
  params: {catalog1Id: catalog1Id}
});

/**
 * @returns {*}
 * @description 删除二级分类
 */
export const deletePmsBaseCatalog2 = (catalog2Id) => itemRequest.get("/deletePmsBaseCataLog2", {
  params: {catalog2Id: catalog2Id}
});

/**
 * @returns {*}
 * @description 删除三级分类
 */
export const deletePmsBaseCatalog3 = (catalog3Id) => itemRequest.get("/deletePmsBaseCataLog3", {
  params: {catalog3Id: catalog3Id}
});

/**
 * @returns {*}
 * @description 添加一级分类
 */
export const addPmsBaseCataLog1 = (name) => itemRequest.get("/addPmsBaseCataLog1", {
  params: {name: name}
});

/**
 * @returns {*}
 * @description 添加二级分类
 */
export const addPmsBaseCataLog2 = (name, catalog1Id) => itemRequest.get("/addPmsBaseCataLog2", {
  params: {name: name, catalog1Id: catalog1Id}
});

/**
 * @returns {*}
 * @description 添加三级分类
 */
export const addPmsBaseCataLog3 = (name, catalog2Id) => itemRequest.get("/addPmsBaseCataLog3", {
  params: {name: name, catalog2Id: catalog2Id}
});

