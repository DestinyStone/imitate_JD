import axios from "axios"
import VueCookie from "vue-cookie"
import {NameType} from "../../common/NameType";

let passportRequest = axios.create({
  baseURL: "http://localhost:8081",
  timeout: 5000
});

passportRequest.interceptors.request.use(config => {
  let token = VueCookie.get(NameType.COOKIE_NAME)
  if (token != null && token != "") {
    config.headers["token"] = token
  }
  return config;
},error => {

  return error;
});

export default passportRequest;
