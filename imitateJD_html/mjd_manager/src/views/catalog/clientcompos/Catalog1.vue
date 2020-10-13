<template>
    <div>
        <catalog-context :tableData="pmsBaseCataLog1" ref="catalogContext"
                        @selectNextCatalog="selectNextCatalog"
                         :selectShow="true"
                         @handlerEdit="handlerEdit"
                         @handleDelete="handlerDelete"
                         @addAttrHandler="addAttrHandler"
        ></catalog-context>
    </div>
</template>

<script>
  import CatalogSelect from "./CatalogSelect";
  import CatalogContext from "./CatalogContext";
  import {
    addPmsBaseCataLog1,
    deletePmsBaseCatalog1,
    getPmsBaseCataLog1,
    updatePmsBaseCatalog1
  } from "../../../network/item/itemApi";
  export default {
    name: "Catalog1",
    data() {
      return{
        pmsBaseCataLog1: null
      }
    },
    components: {CatalogContext, CatalogSelect},
    methods: {
        async getCatalog() {
          const requestData = await getPmsBaseCataLog1();
          this.pmsBaseCataLog1 = requestData.data.responseMessage;
        },
      selectNextCatalog(data) {
          this.$router.push({path:"catalog2", query:{catalog1Id: data.catalogId}})
      },
      handlerEdit(data) {
        this.$refs.catalogContext.open(data.row, "更改名称", this.updatePmsCatalog1);
      },
      handlerDelete(data) {
        this.$refs.catalogContext.deleteHint(data.row.id, this.deleteCatalog1);
      },
      addAttrHandler() {
        this.$refs.catalogContext.addAttr("一级分类", this.addPmsBaseCataLog1);
      },
      async updatePmsCatalog1(id, name) {
        const responseBody = await updatePmsBaseCatalog1(id, name)
        if (responseBody == null || responseBody.data.status == false)
          return false;
        await this.getCatalog();
        return true;
      },
      async deleteCatalog1(id) {
        const responseBody = await deletePmsBaseCatalog1(id);
        if (responseBody == null) return false;
        await this.getCatalog();
        return responseBody.data.status;
      },
      async addPmsBaseCataLog1(name) {
        const responseBody = await addPmsBaseCataLog1(name);
        if (responseBody == null) {
          return false;
        }
        await this.getCatalog();
        return responseBody.data;
      }
    },
    created() {
      this.getCatalog();
    }
  }
</script>

<style scoped>

</style>
