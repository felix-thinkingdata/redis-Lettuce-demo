package cn.thinkingdata.redis.config.strategy;

import cn.thinkingdata.redis.config.RedissonProperties;
import org.redisson.config.Config;

/**
 * class_name: RedissonConfigContext
 * package: cn.thinkingdata.redis.config.strategy
 * describe: Redisson 配置上下文，产出真正的Redisson的Config
 * creat_user: felix@thinkingdata.cn
 * creat_date: 2020/4/14
 * creat_time: 11:17 上午
 **/
public class RedissonConfigContext {

    private RedissonConfigStrategy redissonConfigStrategy = null;

    public RedissonConfigContext(RedissonConfigStrategy _redissonConfigStrategy) {
        this.redissonConfigStrategy = _redissonConfigStrategy;
    }

    /**
     * describe: 上下文根据构造中传入的具体策略产出真是的Redission的config
     * creat_user: felix@thinkingdata.cn
     * creat_date: 2020/4/14
     * creat_time: 11:43 上午
     **/
    public Config createRedissonConfig(RedissonProperties redissonProperties) {
        return this.redissonConfigStrategy.createRedissonConfig(redissonProperties);
    }

}
