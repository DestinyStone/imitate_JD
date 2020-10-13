<template>
    <div class="catalog-select">
        <el-tag
                class="el-tag"
                v-for="(tag,index) in currentTagData"
                :key="tag.name"
                :closable="index==0?false:true"
                :type="tag.type"
                @click.prevent="showCatalgLeve(index)"
                @close="closeCataLeve(index)"
        >
            {{tag.name}}
        </el-tag>
    </div>
</template>

<script>
  import {mapMutations} from "vuex";

  export default {
    name: "CatalogSelect",
    data() {
      return{
        currentTagData: [{ name: '一级分类', type: '' }],
        tags: [
          { name: '一级分类', type: '' },
          { name: '二级分类', type: 'success' },
          { name: '三分类', type: 'info' },
        ],
        route: [{name: "catalog1", query: null}, {name: "catalog2", query: null}, {name: "catalog3", query: null}]
      }
    },
    methods: {
      ...mapMutations("api", ['popCurrentPath']),
      currentTags(index) {
        this.currentTagData =  this.tags.slice(0, index+1);
      },
      showCatalgLeve(index) {
        this.$router.push({path: this.route[index].name, query:this.route[index].query});
      },
      tagsListener() {
        let pathStr = this.$route.path;
        if (pathStr.indexOf("/catalog1") != -1) {
          this.currentTags(0);
          this.route[0].query = this.$route.query;
        }
        if (pathStr.indexOf("/catalog2") != -1) {
          this.currentTags(1);
          this.route[1].query = this.$route.query;
        }

        if (pathStr.indexOf("/catalog3") != -1) {
          this.currentTags(2);
          this.route[2].query = this.$route.query;
        }
      },
      closeCataLeve(index) {
        if (index > 0) index--;
        this.popCurrentPath();
        this.$router.push({path: this.route[index].name, query:this.route[index].query})
      }
    },
    computed: {
    },
    watch: {
      $route() {
        this.tagsListener();
      }
    },
    created() {
      this.tagsListener();
    }
  }
</script>

<style scoped>
    .catalog-select{
        margin-top: 20px;
        padding-left: 20px;
        border-bottom: 1px solid red;
    }
    .catalog-select >  .el-tag{
        cursor: pointer;
    }
</style>
