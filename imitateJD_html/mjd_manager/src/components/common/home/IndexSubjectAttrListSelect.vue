<template>
    <div>
        <index-subject-select>
            <custom-el-select v-for="(item, key) in state.tagHintsCatalog"
                              :tagHint="key"
                              :options="item"
                              @getData="getData"
                              @changeData = "changeDataListener"
                              :ref="key"
                              >
            </custom-el-select>
        </index-subject-select>
    </div>
</template>

<script>
  import IndexSubjectSelect from "../../content/home/IndexSubjectSelect";
  import CustomElSelect from "../../content/home/CustomElSelect"
  import {mapActions, mapState} from "vuex"

  export default {
    name: "IndexSubjectAttrListSelect",
    components: {IndexSubjectSelect, CustomElSelect},
    data() {
      return {
      }
    },
    computed: {
      ...mapState('home', {
        state: state => state
      })
    },
    methods: {
      ...mapActions('home', ['getPmsBaseCataLog']),
      ...mapActions('home', ['getPmsBaseAttrInfoList']),
      getData(tagHint, value) {
        if (tagHint == "一级分类") {
          this.getPmsBaseCataLog({"tagHint": tagHint, "catalogId": null});
        }

        if (tagHint == "二级分类"){
          if (this.$refs.一级分类[0].value == null || this.$refs.一级分类[0].value == "") {
            this.open("请选择一级分类", "警告");
            return;
          }
          this.getPmsBaseCataLog({"tagHint": tagHint, "catalogId": this.$refs.一级分类[0].value});
        }
        if (tagHint == "三级分类"){
          if (this.$refs.二级分类[0].value == null || this.$refs.二级分类[0].value == "") {
            this.open("请选择二级分类", "警告");
            return;
          }
          this.getPmsBaseCataLog({"tagHint": tagHint, "catalogId": this.$refs.二级分类[0].value});
        }
      },
      open(message, level) {
        this.$alert(message, level, {
          confirmButtonText: '确定'
        });
      },
      changeDataListener(data) {
        if (data.tagHint == "一级分类") {
          this.$refs.二级分类[0].value = "";
          this.$refs.三级分类[0].value = "";
        }
        if (data.tagHint == "二级分类") {
          this.$refs.三级分类[0].value = "";
        }
        if (data.tagHint == "三级分类") {
            this.getPmsBaseAttrInfoList(this.$refs.三级分类[0].value);
        }else {
          this.getPmsBaseCataLog({"tagHint": data.tagHint, "catalogId": data.newValue});
        }
      }

    }
  }
</script>

<style scoped>

</style>
