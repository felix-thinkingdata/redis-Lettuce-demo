package cn.thinkingdata.redis.config.strategy.impl;

import cn.thinkingdata.redis.config.RedissonProperties;
import cn.thinkingdata.redis.config.strategy.RedissonConfigStrategy;
import cn.thinkingdata.redis.constant.GlobalConstant;
import org.apache.commons.lang3.StringUtils;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * class_name: StandaloneRedissonConfigStrategyImpl
 * package: cn.thinkingdata.redis.config.strategy.impl
 * describe: 单机方式Redisson配置
 * creat_user: felix@thinkingdata.cn
 * creat_date: 2020/4/14
 * creat_time: 2:00 下午
 **/
public class StandaloneRedissonConfigStrategyImpl implements RedissonConfigStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(StandaloneRedissonConfigStrategyImpl.class);

    @Override
    public Config createRedissonConfig(RedissonProperties redissonProperties) {
        Config config = new Config();
        try {
            String address = redissonProperties.getAddress();
            String password = redissonProperties.getPassword();
            int database = redissonProperties.getDatabase();
            String redisAddr = GlobalConstant.REDIS_CONNECTION_PREFIX.getConstant_value() + address;
            config.useSingleServer().setAddress(redisAddr);
            config.useSingleServer().setDatabase(database);
            if (StringUtils.isNotBlank(password)) {
                config.useSingleServer().setPassword(password);
            }
            LOGGER.info("初始化[standalone]方式Config,redisAddress:" + address);
        } catch (Exception e) {
            LOGGER.error("standalone Redisson init error", e);
            e.printStackTrace();
        }
        return config;
    }
}
