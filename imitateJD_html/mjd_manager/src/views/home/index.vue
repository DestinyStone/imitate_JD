<template>
    <div id="index">
        <nav-menu id="nav-menu" ref="navMenu"></nav-menu>
        <index-subject id="index-subject" @click.native="packUpNavMenu"></index-subject>
    </div>
</template>

<script>


  import NavMenu from "./chlidcompos/NavMenu";
  import IndexSubject from "./chlidcompos/IndexSubject";
  export default {
    name: "index",
    components: {
      IndexSubject,
      NavMenu

    },
    methods: {
      packUpNavMenu() {
        if (!this.$refs.navMenu.isCollapse) {
          this.$refs.navMenu.isCollapse = true;
          this.$refs.navMenu.collapseContent="展开";
        }

      }
    },
    created() {
    }
  }
</script>

<style scoped>
    #index{
        width: 100%;
        height: 100%;
        display: flex;
    }
    #nav-menu{
        /*width: 200px;*/
        /*height: 100%;*/
    }
    #index-subject{
        width: 100%;
        height: 100%;
        float: left;
    }
</style>
