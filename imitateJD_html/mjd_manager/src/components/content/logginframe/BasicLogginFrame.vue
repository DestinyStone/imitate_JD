<template>
    <div class="basic-loggin-frame">
        <div><img id="tag" :src="args.src"/></div>
        <input id="input-message" @click="currentInputContent" :placeholder="args.placeholder" :type="args.type" v-model="inputContent"/>
        <div id="look"></div>
    </div>
</template>

<script>
  export default {
    name: "BasicLogginFrame",
    data() {
      return{
        inputContent: null,
        args: {
          src: null,
          placeholder: null,
          type: null
        },
        usernameType: {
          src: require("@/assets/img/login/loggin-frame-tag-user.png"),
          placeholder: "请输入用户名",
          type: "text"
        },
        passwordType: {
          src: require("@/assets/img/login/loggin-frame-tag-password.png"),
          placeholder: "请输入密码",
          type: "password"
        }
      }
    },
    props: {
      inputType:{
        type: String,
        default: "username"
      }
    },
    created() {
      this.setArgs();
    },
    methods: {
      setArgs() {
        if (this.inputType == "username") {
          this.args = this.usernameType;
          return;
        }
        if (this.inputType == "password") {
          this.args = this.passwordType;
          return;
        }
      },
      sendInputContent() {
        this.$emit("inputContent", this.inputContent);
      },
      currentInputContent() {
        this.$emit("currentInputContent", this.inputType);
      }
    }
  }
</script>

<style scoped>
    .basic-loggin-frame{
        width: 70%;
        height: 52px;
        display: flex;
        border: 1px solid rgba(255, 255, 255, 0.1);
        background: rgba(0, 0, 0, 0.1);
        border-radius: 5px;
        color: #454545;
        align-items:center;
    }
    .basic-loggin-frame #tag{
        width: 15px;
        hight: 15px;
        margin-left: 15px;
        display: block;
    }
    .basic-loggin-frame #input-message {
        height: 100%;
        width: 70%;
        -webkit-tap-highlight-color: rgba(255, 255, 255, 0);
        -webkit-user-select: none;
        -moz-user-focus: none;
        -moz-user-select: none;
        -webkit-appearance:none;
        outline: none;
        border: none;
        background-color: transparent;
        margin-left: 15px;
    }
</style>
