<template>
    <div>
        <custom-index-subject-main class="custom-index-subject-main">
            <el-button slot="addAttrButton" type="primary">主要按钮</el-button>
            <el-button slot="addAttrButton" type="primary">主要按钮</el-button>
            <!--<div class="test" slot="selectList">222222222222222</div>-->
            <custom-el-table class="custom-el-table"
                             slot="selectList"
                            :tableData="state.pmsBaseAttrInfoList"
            ></custom-el-table>
        </custom-index-subject-main>
    </div>
</template>

<script>
  import CustomIndexSubjectMain from "../../content/home/CustomIndexSubjectMain";
  import CustomElTable from "../../content/home/customElTable";
  import {mapState} from "vuex"

  export default {
    name: "IndexSubjectAttrListMain",
    components: {CustomElTable, CustomIndexSubjectMain},
    methods: {

    },
    computed: {
      ...mapState('home', {
        state: state => state
      })
    }
  }
</script>

<style scoped>
    .custom-index-subject-main{
        width: 100%;
        height: 100%;
        padding-top: 20px;
    }
    .custom-index-subject-main > .el-button {
        margin-left: 20px;
    }
    .custom-index-subject-main > .custom-el-table{
        margin-top: 10px;
        width: 100%;
        height: 100%;
    }
</style>
