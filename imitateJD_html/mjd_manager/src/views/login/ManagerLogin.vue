<template>
    <div id="manager-login">
        <manager-login-view ref="loginView" @login="loginRequest"></manager-login-view>
    </div>
</template>

<script>
  import ManagerLoginView from "./childcompos/ManagerLoginView";
  import {remoteLogin} from "../../network/passport/passportApi";
  import {NameType} from "../../common/NameType";

  export default {
    name: "ManagerLogin",
    components: {ManagerLoginView},
    methods: {
      loginRequest(user) {
        remoteLogin(user).then(responsebody => {
          if (responsebody.data.status==true && responsebody.data.responseCode==20000) {
            this.$cookie.set(NameType.COOKIE_NAME, responsebody.headers.token, 1000*60*60);
            this.$router.replace(this.$route.matched[0].meta.fromPath);
          } else {
            this.$refs.loginView.status = this.$refs.loginView.statusCode.ERROR;
          }
        });
      }
    }
  }
</script>

<style scoped>
    #manager-login {
        position:absolute;
        top: 0;
        bottom: 0;
        width: 100%;
        background-color: #2d3a4b;
    }
</style>
