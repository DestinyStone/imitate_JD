<template>
    <div>
        <index-subject-main id="index-subject-main"></index-subject-main>
        <keep-alive>
            <router-view></router-view>
        </keep-alive>
    </div>
</template>

<script>
  import IndexSubjectMain from "../../../components/common/home/IndexSubjectMain";
  import IndexSubjectTarbar from "../../../components/common/home/IndexSubjectTarbar";
  export default {
    name: "IndexSubject",
    components: {IndexSubjectTarbar, IndexSubjectMain}
  }
</script>

<style scoped>
    #index-subject-main{
        width: 100%;
        height: 50px;
    }
</style>
