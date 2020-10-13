package response.type;

/**
 * @Auther: ASUS
 * @Date: 2020/10/10 00:15
 * @Description: 响应状态码类型
 */
public class ResponseCodeType {

    /** @Description: 正常请求 */
    public static Integer SUCCESS = 20000;
    /** @Description: 参数错误 */
    public static Integer PARAM_ERROR = 40001;
    /** @Description: 未知错误 */
    public static final Integer UN_KNOW_ERROR = 49999;

    /**          登录相关         **/
    /** @Description: 登录成功 */
    public static Integer LOGIN_SUCCESS=20000;
    /** @Description: 登录状态中 */
    public static Integer LOGIN_STATUS = 21000;
    /** @Description: 未登录状态 */
    public static Integer NO_LOGIN_STATUS = 21001;
    /** @Description: Token过期 */
    public static Integer TOKEN_EXPIRED = 21002;
}
