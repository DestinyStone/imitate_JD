import passportRequest from "./passportRequest"

/**
 * @author DestinyStone
 * @date 2020/10/10 00:29
 */

/**
 * @param username 用户名
 * @param password 密码
 * @returns {*}
 * @description 用户登录
 */
export const remoteLogin = (user) => passportRequest.post("/login", `username=${user.username}&password=${user.password}`);

/**
 * @returns {*}
 * @description 查询用户登录状态
 */
export const loginStatus = () => passportRequest.get("/loginStatus").catch(error=>{console.log(error)});
