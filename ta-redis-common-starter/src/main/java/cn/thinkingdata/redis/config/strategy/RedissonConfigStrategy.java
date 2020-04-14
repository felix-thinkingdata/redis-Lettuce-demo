package cn.thinkingdata.redis.config.strategy;

import cn.thinkingdata.redis.config.RedissonProperties;
import org.redisson.config.Config;

/**
 * class_name: RedissonConfigStrategy
 * package: cn.thinkingdata.redis.config.strategy
 * describe: Redisson配置构建接口
 * creat_user: felix@thinkingdata.cn
 * creat_date: 2020/4/14
 * creat_time: 11:18 上午
 **/
public interface RedissonConfigStrategy {

    /**
     * describe: 根据不同的Redis配置创建对应的Config
     * creat_user: felix@thinkingdata.cn
     * creat_date: 2020/4/14
     * creat_time: 11:27 上午
     **/
    Config createRedissonConfig(RedissonProperties redissonProperties);

}
