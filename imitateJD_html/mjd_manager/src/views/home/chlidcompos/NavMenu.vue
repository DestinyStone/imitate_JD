<template>
    <div id="nav-menu">
        <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">
            <div id="change_collapse" @click="changeCollapse">{{collapseContent}}</div>
            <el-submenu index="1">
                <template slot="title">
                    <i class="el-icon-eleme"></i>
                    <span slot="title">基本信息管理</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item index="1-1" @click="elMenuItemRouter('catalog/catalog1','平台分列列表')">平台分类列表</el-menu-item>
                    <el-menu-item index="1-2" @click="elMenuItemRouter('attrList','平台属性列表')">平台属性列表</el-menu-item>
                </el-menu-item-group>
            </el-submenu>
            <el-submenu index="2">
                <template slot="title">
                    <i class="el-icon-shopping-bag-1"></i>
                    <span slot="title">商品信息管理</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item index="1-1" @click="elMenuItemRouter('spuManager','商品属性SPU管理')">商品属性SPU管理</el-menu-item>
                    <el-menu-item index="1-2" @click="elMenuItemRouter('skuManager','商品属性SKU管理')">商品属性SKU管理</el-menu-item>
                </el-menu-item-group>
            </el-submenu>
        </el-menu>
    </div>
</template>

<script>
  import {mapMutations} from "vuex"

  export default {
    name: "NavMenu",
    data() {
      return{
        isCollapse: false,
        collapseContent: "收起",
      }
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      changeCollapse() {
        this.isCollapse = !this.isCollapse;
        if (this.isCollapse == true) {
          this.collapseContent="展开";
        } else {
          this.collapseContent="收起";
        }
      },
      ...mapMutations('api', ['setCurrentPath']),
      elMenuItemRouter(uri, innerText) {
        this.setCurrentPath(innerText);
        this.$router.replace("/index/" + uri);
      }
    }
  }
</script>

<style scoped>
    .el-menu-vertical-demo:not(.el-menu--collapse) {
        width: 200px;
        height: 100%;
        min-height: 100%;
    }
    #change_collapse{
        width: 100%;
        height: 50px;
        text-align: center;
        padding-top: 15px;
        font-family: "Blod";
        cursor: pointer;
        background-color: #F2F6FC;
    }
</style>
