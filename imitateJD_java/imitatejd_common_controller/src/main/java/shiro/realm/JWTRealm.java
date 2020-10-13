package shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import shiro.token.JWTToken;
import utils.JwtUtil;

/**
 * @Auther: ASUS
 * @Date: 2020/10/10 13:28
 * @Description:
 */
public class JWTRealm extends AuthorizingRealm {
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)throws AuthenticationException{

        String tokenStr = token.getPrincipal().toString();
        boolean verify = JwtUtil.verify(token.getPrincipal().toString(), JwtUtil.getUsername(token.getPrincipal().toString()));

        if (!verify) {
            throw new UnknownAccountException("token 过期");
        }

        return new SimpleAuthenticationInfo(tokenStr, tokenStr, this.getName());
    }
}
