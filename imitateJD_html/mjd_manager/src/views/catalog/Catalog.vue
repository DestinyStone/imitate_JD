<template>
    <div id="catalog">
        <catalog-select></catalog-select>
        <keep-alive>
            <router-view></router-view>
        </keep-alive>
    </div>
</template>

<script>
  import CatalogSelect from "./clientcompos/CatalogSelect";
  import CatalogContext from "./clientcompos/CatalogContext";
  export default {
    name: "Catalog",
    components: {CatalogContext, CatalogSelect}
  }
</script>

<style scoped>
    .catalog{

    }
</style>
