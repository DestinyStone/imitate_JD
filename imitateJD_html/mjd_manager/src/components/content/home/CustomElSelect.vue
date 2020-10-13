<template>
    <div class="custom-el-select">
        <div class="select-hint">{{tagHint}}:</div>
        <el-select class="select-main" v-model="value" placeholder="请选择" @mouseup.native="getData()">
            <el-option
                    v-for="item in options"
                    :key="item.id"
                    :label="item.name"
                    :value="item.id">
            </el-option>
        </el-select>
    </div>
</template>

<script>
  export default {
    name: "CustomElSelect",
    props: {
      tagHint: {
        type: String
      },
      options: {
        type: Array
      }
    },
    data() {
      return{
        value: ""
      }
    },
    methods: {
      getData() {
        this.$emit("getData", this.tagHint, this.value);
      }
    },
    watch: {
      value(old, newValue) {
        this.$emit("changeData", {tagHint: this.tagHint, newValue: newValue});
      }
    }
  }
</script>

<style scoped>
    .custom-el-select{
        display: flex;
        flex-flow: row;
        align-items: center;
    }
    .custom-el-select > .select-hint{

    }
    .custom-el-select> .select-main{
        margin-left: 10px;
    }
</style>
