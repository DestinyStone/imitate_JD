<template>
    <div id="index-subject-attr-list">
        <index-subject-attr-list-select id="index-subject-attr-list-select"></index-subject-attr-list-select>
        <index-subject-attr-list-main id="index-subject-attr-list-main"></index-subject-attr-list-main>
    </div>
</template>

<script>

  import IndexSubjectSelect from "../../content/home/IndexSubjectSelect";
  import IndexSubjectAttrListSelect from "./IndexSubjectAttrListSelect";
  import IndexSubjectAttrListMain from "./IndexSubjectAttrListMain";
  export default {
    name: "IndexSubjectAttrList",
    components: {IndexSubjectAttrListMain, IndexSubjectAttrListSelect, IndexSubjectSelect},
    data() {
      return {}
    }
  }
</script>

<style scoped>
    #index-subject-attr-list{
        display: flex;
        flex-flow: column;
        height: 100%;
    }
    #index-subject-attr-list > #index-subject-attr-list-select {
        flex: 1;
    }
    #index-subject-attr-list > #index-subject-attr-list-main{
        flex: 10;
    }
</style>
