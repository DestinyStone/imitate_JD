<template>
    <div id="manager-login-view">
        <h3 id="manager-login-subject">仿京东后台登录系统</h3>
        <basic-loggin-frame ref="username" input-type="username" @currentInputContent="currentInputContent"></basic-loggin-frame>
        <basic-loggin-frame ref="password" input-type="password" @currentInputContent="currentInputContent"></basic-loggin-frame>
        <div id="login" @click="login()">登录</div>
        <div id="status">{{status}}</div>
    </div>
</template>

<script>
  import BasicLogginFrame from "../../../components/content/logginframe/BasicLogginFrame";
  export default {
    name: "ManagerLoginView",
    data() {
      return {
        status: "无状态",
        statusCode: {
          "NO_STATUS" : "无状态",
          "INPUT": "${X}输入中",
          "NULL": "${X}为空",
          "LEN_LT": "${X}长度过短(必须大于5位)",
          "LEN_GT": "${X}长度过长(必须小于12位)",
          "CHAR_ERROR": "${X}存在特殊字符(必须使用数字/英文)",
          "LOGIN": "登录中",
          "ERROR": "错误"
        },
        user: {
          username: null,
            password: null
        }
      }
    },
    components: {BasicLogginFrame},
    methods: {
        login() {
          this.user.username = this.$refs.username.inputContent;
          this.user.password = this.$refs.password.inputContent;

          if (this.check(this.user.username, "username") && this.check(this.user.password, "password")) {
            this.$emit("login", this.user);
            this.status = this.statusCode.LOGIN;
          }

        },
        check(data, type) {
          if (!(this.checkNULL(data, type) && this.checkLen(data, type))) {
            return false;
          }
          return true;
        },
        checkNULL(data, type) {
          if (data == null || data.length == 0) {
            this.setResponseMessage(type, this.statusCode.NULL);
            return false;
          }
          return true;
        },
        checkLen(data, type) {
          if (data == null || data.length <= 5) {
            this.setResponseMessage(type, this.statusCode.LEN_LT);
            return false;
          }
          if (data.length >=12) {
            this.setResponseMessage(type, this.statusCode.LEN_GT);
            return false;
          }
          return true;
        },
        setResponseMessage(type, message) {
          if (type == "username") {
            this.status = message.replaceAll("${X}", "用户名")
          }
          if (type == "password") {
            this.status =  message.replaceAll("${X}", "密码")
          }
        },
      currentInputContent(type) {
        if (type == "username") {
          this.status = this.statusCode.INPUT.replaceAll("${X}", "用户名");
        }
        if (type == "password") {
          this.status =  this.statusCode.INPUT.replaceAll("${X}", "密码")
        }
      }
    }
  }
</script>

<style scoped>
    #manager-login-view{
        width: 40%;
        min-width: 400px;
        height: 300px;
        margin: 10% auto;
    }
    #manager-login-subject{
        font-size: 26px;
        font-weight: 400;
        color: #eee;
        margin: 0px auto 40px auto;
        text-align: center;
        font-weight: bold;
    }
    #manager-login-view .basic-loggin-frame {
        margin: 0 auto;
        margin-bottom: 25px;
    }
    #login{
        width: 70%;
        display: inline-block;
        line-height: 1;
        white-space: nowrap;
        cursor: pointer;
        background: #fff;
        border: 1px solid #dcdfe6;
        color: #606266;
        -webkit-appearance: none;
        text-align: center;
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
        outline: 0;
        -webkit-transition: .1s;
        transition: .1s;
        font-weight: 500;
        display: block;
        padding: 12px 20px;
        font-size: 14px;
        border-radius: 4px;
        margin: 0 auto;
    }
    #status{
        width: 70%;
        height: 52px;
        border: 1px solid rgba(255, 255, 255, 0.1);
        background: rgba(0, 0, 0, 0.1);
        border-radius: 5px;
        color: #ffccff;
        text-align: center;
        padding-top: 15px;
        box-sizing: padding-box;
        margin: 0 auto;
        margin-top: 30px;
    }
</style>
