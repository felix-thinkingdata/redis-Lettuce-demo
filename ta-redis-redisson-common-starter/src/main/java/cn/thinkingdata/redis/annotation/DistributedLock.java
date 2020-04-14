package cn.thinkingdata.redis.annotation;


import java.lang.annotation.*;


/**
 * class_name: DistributedLock
 * package: cn.thinkingdata.redis.annotation
 * describe: Redisson分布式锁注解
 * creat_user: felix@thinkingdata.cn
 * creat_date: 2020/4/14
 * creat_time: 2:03 下午
 **/
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DistributedLock {

    /**分布式锁名称*/
    String value() default "distributed-lock-redisson";
    /**锁超时时间,默认十秒*/
    int expireSeconds() default 10;
}
