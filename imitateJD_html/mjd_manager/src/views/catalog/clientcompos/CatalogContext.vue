<template>
    <div class="catalog-context">
        <el-button type="primary" @click.native="addAttrHandler">增加属性</el-button>
        <el-table
                :data="tableData"
                style="width: 100%; min-width: 600px"
                :height="tableHight"
        >
            <el-table-column
                    prop="id"
                    label="编号"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="名称"
                    width="180">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button v-show="selectShow"
                            size="mini"
                            @click="selectNextCatalog(scope.$index, scope.row)">查看</el-button>
                    <el-button
                            size="mini"
                            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    import {mapMutations} from "vuex"

  export default {
    name: "CatalogContext",
    data(){
      return{
        tableHight: window.innerHeight - 170
      }
    },
    props: {
      tableData: {
        type: Array
      },
      selectShow: {
        type: Boolean
      }
    },
    methods: {
      ...mapMutations('api', ['addCurrentPath']),
      selectNextCatalog(catalogId, row) {
        this.$emit("selectNextCatalog",{catalogId: this.tableData[catalogId].id, row: row});
        this.addCurrentPath(row.name);
      },
      handleEdit(catalogId, row) {
        this.$emit("handlerEdit", {catalogId: this.tableData[catalogId].id, row: row});
      },
      handleDelete(catalogId, row) {
        this.$emit("handleDelete", {catalogId: this.tableData[catalogId].id, row: row});
      },
      open(data, title, backMethod) {
        this.$prompt('', title, {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          inputValue:data.name,
        }).then(({ value }) => {
          backMethod(data.id, value).then(result => {
            if (result == true) {
              this.$message({
                type: 'success',
                message: '更改成功: ' + value
              });
            } else {
              this.$message({
                type: 'error',
                message: '更改失败: ' + value
              });
            }
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消更改'
          });
        });
      },
      deleteHint(id, callMethod) {
        this.$confirm('删除后将不可找回', '确认信息', {
          distinguishCancelAndClose: true,
          confirmButtonText: '删除',
          cancelButtonText: '放弃删除'
        })
          .then(() => {
            callMethod(id).then(response => {
              if (response) {
                this.$message({
                  type: 'info',
                  message: '已删除'
                });
              }else {
                this.$message({
                  type: 'error',
                  message: '删除失败'
                });
              }
            })
          })
          .catch(action => {
            this.$message({
              type: 'info',
              message: action === 'cancel'
                ? '放弃保存并离开页面'
                : '停留在当前页面'
            })
          });
      },
      addAttrHandler() {
        this.$emit("addAttrHandler");
      },
      addAttr(message, callmethod) {
        this.$prompt('', message, {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
        }).then(({ value }) => {
          callmethod(value).then(result => {
            if (result.status == true) {
              this.$message({
                type: 'success',
                message: '增加成功: ' + value
              });
              return;
            }

            if (result.status == false) {
              this.$message({
                type: 'error',
                message: result.responseMessage + ":" + value
              });
              return;
            }

            if (result == false) {
              this.$message({
                type: 'error',
                message: '增加异常'
              });
            }
          })
        }).catch(error => {
          this.$message({
            type: 'info',
            message: '取消添加'
          });
        })
      }
    }
  }
</script>

<style scoped>
    .catalog-context{
        margin-top: 20px;
        margin-left: 20px;
    }
</style>
