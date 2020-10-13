import axios from "axios"

let itemRequest = axios.create({
  baseURL: "http://localhost:8082",
  timeout: 5000
});

export default itemRequest;
