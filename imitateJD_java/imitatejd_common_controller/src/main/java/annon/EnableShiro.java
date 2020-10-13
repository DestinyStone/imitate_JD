package annon;

import config.ShiroConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Auther: DestinyStone
 * @Date: 2020/10/9 14:16
 * @Description: 启动类上添加该注解，则开启shiro配置
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ShiroConfig.class)
public @interface EnableShiro {
}
