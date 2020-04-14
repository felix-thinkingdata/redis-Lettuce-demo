package cn.thinkingdata.redis.config.strategy.impl;

import cn.thinkingdata.redis.config.RedissonProperties;
import cn.thinkingdata.redis.config.strategy.RedissonConfigStrategy;
import cn.thinkingdata.redis.constant.GlobalConstant;
import org.apache.commons.lang3.StringUtils;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClusterRedissonConfigStrategyImpl implements RedissonConfigStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClusterRedissonConfigStrategyImpl.class);

    @Override
    public Config createRedissonConfig(RedissonProperties redissonProperties) {
        Config config = new Config();
        try {
            String address = redissonProperties.getAddress();
            String password = redissonProperties.getPassword();
            String[] addrTokens = address.split(",");
            /**设置cluster节点的服务IP和端口*/
            for (int i = 0; i < addrTokens.length; i++) {
                config.useClusterServers()
                        .addNodeAddress(GlobalConstant.REDIS_CONNECTION_PREFIX.getConstant_value() + addrTokens[i]);
                if (StringUtils.isNotBlank(password)) {
                    config.useClusterServers().setPassword(password);
                }
            }
            LOGGER.info("初始化[cluster]方式Config,redisAddress:" + address);
        } catch (Exception e) {
            LOGGER.error("cluster Redisson init error", e);
            e.printStackTrace();
        }
        return config;
    }

}

