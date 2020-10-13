<template>
    <div class="index_subject_select">
        <slot>
        </slot>
    </div>
</template>

<script>
  import CustomElSelect from "./CustomElSelect";
  export default {
    name: "IndexSubjectSelect",
    components: {CustomElSelect}
  }
</script>

<style scoped>
    .index_subject_select{
        display: flex;
        flex-flow: row;
    }
    .index_subject_select > .custom-el-select{
        margin-left: 30px;
        margin-top: 20px;
    }
</style>
