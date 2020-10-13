<template>
    <div>
        <catalog-context :tableData="pmsBaseCataLog3" ref="catalogContext"
                         :selectShow="false"
                         @handlerEdit="handlerEdit"
                         @handleDelete="handlerDelete"
                         @addAttrHandler="addAttrHandler"
        ></catalog-context>
    </div>
</template>

<script>
  import CatalogContext from "./CatalogContext";
  import {
    addPmsBaseCataLog3,
    deletePmsBaseCatalog3,
    getPmsBaseCataLog3,
    updatePmsBaseCatalog3
  } from "../../../network/item/itemApi";
  export default {
    name: "Catalog3",
    components: {CatalogContext},
    data() {
      return{
        pmsBaseCataLog3: null
      }
    },
    methods: {
      async getCatalog() {
        let catalog2Id = this.$route.query.catalog2Id;
        const requestData = await getPmsBaseCataLog3(catalog2Id);
        this.pmsBaseCataLog3 = requestData.data.responseMessage;
      },
      handlerEdit(data) {
        this.$refs.catalogContext.open(data.row, "更改名称", this.updatePmsCatalog3);
      },
      handlerDelete(data) {
        this.$refs.catalogContext.deleteHint(data.row.id, this.deleteCatalog3);
      },
      addAttrHandler() {
        this.$refs.catalogContext.addAttr("三级分类", this.addPmsBaseCataLog3);
      },
      async updatePmsCatalog3(id, name) {
        const responseBody = await updatePmsBaseCatalog3(id, name)
        if (responseBody == null || responseBody.data.status == false)
          return false;
        await this.getCatalog();
        return true;
      },
      async deleteCatalog3(id) {
        const responseBody = await deletePmsBaseCatalog3(id)
        if (responseBody == null) return false;
        await this.getCatalog();
        return responseBody.data.status;
      },
      async addPmsBaseCataLog3(name) {
        let catalog2Id = this.$route.query.catalog2Id;
        if (catalog2Id == null) {
          this.$message({
            type: 'error',
            message: "二级分类id异常"
          });
          return;
        }
        const responseBody = await addPmsBaseCataLog3(name, catalog2Id);
        if (responseBody == null) {
          return false;
        }
        await this.getCatalog();
        return responseBody.data;
      }
    },
    activated() {
      this.getCatalog();
    }
  }
</script>

<style scoped>

</style>
