package cn.thinkingdata.redis.config;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * class_name: EnableRedissonLock
 * package: cn.thinkingdata.redis.config
 * describe: 开启Redisson注解支持
 * creat_user: felix@thinkingdata.cn
 * creat_date: 2020/4/14
 * creat_time: 2:02 下午
 **/
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RedissonAutoConfiguration.class)
public @interface EnableRedissonLock {
}
