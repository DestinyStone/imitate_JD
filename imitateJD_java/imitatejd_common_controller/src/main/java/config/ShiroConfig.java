package config;

import filter.JWTFilter;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import shiro.CustomModularRealmAuthenticator;
import shiro.factory.NoSessionsSubjectFactory;
import shiro.realm.JWTRealm;
import shiro.realm.UsernamePasswordRealm;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * @Auther: DestinyStone
 * @Date: 2020/10/9 14:16
 * @Description: shior配置类
 */

public class ShiroConfig {
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        LinkedHashMap<String, Filter> fliterMap = new LinkedHashMap<String, Filter>();
        fliterMap.put("jwt", new JWTFilter());
        shiroFilterFactoryBean.setFilters(fliterMap);

        LinkedHashMap<String, String> filterUrlMap = new LinkedHashMap<>();
        filterUrlMap.put("/**", "jwt");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterUrlMap);

        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultSubjectDAO subjectDAO() {
        DefaultSubjectDAO defaultSubjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        defaultSubjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        return defaultSubjectDAO;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("subjectDAO") DefaultSubjectDAO defaultSubjectDAO) {

        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();

        defaultWebSecurityManager.setSubjectFactory(new NoSessionsSubjectFactory());
        defaultWebSecurityManager.setSubjectDAO(defaultSubjectDAO);
        defaultWebSecurityManager.setAuthenticator(new CustomModularRealmAuthenticator());
        defaultWebSecurityManager.setRealms(Arrays.asList(jwtRealm(),usernamePasswordRealm()));
        return defaultWebSecurityManager;
    }

    private UsernamePasswordRealm usernamePasswordRealm() {
        UsernamePasswordRealm usernamePasswordRealm = new UsernamePasswordRealm();
        return usernamePasswordRealm;
    }

    private JWTRealm jwtRealm() {
        JWTRealm jwtRealm = new JWTRealm();
        return jwtRealm;
    }

}
