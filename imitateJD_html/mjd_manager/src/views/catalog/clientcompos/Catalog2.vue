<template>
    <div>
        <catalog-context :tableData="pmsBaseCataLog2" ref="catalogContext"
                         @selectNextCatalog="selectNextCatalog"
                         :selectShow="true"
                         @handlerEdit="handlerEdit"
                         @handleDelete="handlerDelete"
                         @addAttrHandler="addAttrHandler"
        ></catalog-context>
    </div>
</template>

<script>
  import {
    addPmsBaseCataLog2,
    deletePmsBaseCatalog2,
    getPmsBaseCataLog2,
    updatePmsBaseCatalog2
  } from "../../../network/item/itemApi";
  import CatalogContext from "./CatalogContext";

  export default {
    name: "Catalog2",
    components: {CatalogContext},
    data() {
      return{
        pmsBaseCataLog2: null
      }
    },
    methods: {
      async getCatalog() {
        let catalog1Id = this.$route.query.catalog1Id;
        const requestData = await getPmsBaseCataLog2(catalog1Id);
        this.pmsBaseCataLog2 = requestData.data.responseMessage;
      },
      selectNextCatalog(data) {
        this.$router.push({path:"catalog3", query:{catalog2Id: data.catalogId}})
      },
      handlerEdit(data) {
        this.$refs.catalogContext.open(data.row, "更改名称", this.updatePmsCatalog2);
      },
      handlerDelete(data) {
        this.$refs.catalogContext.deleteHint(data.row.id, this.deleteCatalog2);
      },
      addAttrHandler() {
        this.$refs.catalogContext.addAttr("二级分类", this.addPmsBaseCataLog2);
      },
      async updatePmsCatalog2(id, name) {
        const responseBody = await updatePmsBaseCatalog2(id, name)
        if (responseBody == null || responseBody.data.status == false)
          return false;
        await this.getCatalog();
        return true;
      },
      async deleteCatalog2(id) {
        const responseBody = await deletePmsBaseCatalog2(id)
        if (responseBody == null) return false;
        await this.getCatalog();
        return responseBody.data.status;
      },
      async addPmsBaseCataLog2(name) {
        let catalog1Id = this.$route.query.catalog1Id;
        if (catalog1Id == null) {
          this.$message({
            type: 'error',
            message: "一级分类id异常"
          });
          return;
        }
        const responseBody = await addPmsBaseCataLog2(name, catalog1Id);
        if (responseBody == null) {
          return false;
        }
        await this.getCatalog();
        return responseBody.data;
      }
    },
    created() {
    },
    activated() {
      this.getCatalog();
    }
  }
</script>

<style scoped>

</style>
