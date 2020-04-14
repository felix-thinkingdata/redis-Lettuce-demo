package cn.thinkingdata.redis.config.strategy.impl;

import cn.thinkingdata.redis.config.RedissonProperties;
import cn.thinkingdata.redis.config.strategy.RedissonConfigStrategy;
import cn.thinkingdata.redis.constant.GlobalConstant;
import org.apache.commons.lang3.StringUtils;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * class_name: MasterslaveRedissonConfigStrategyImpl
 * package: cn.thinkingdata.redis.config.strategy.impl
 * describe: T主从方式Redisson 配置
 * creat_user: felix@thinkingdata.cn
 * creat_date: 2020/4/14
 * creat_time: 1:48 下午
 **/
public class MasterslaveRedissonConfigStrategyImpl implements RedissonConfigStrategy {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClusterRedissonConfigStrategyImpl.class);

    @Override
    public Config createRedissonConfig(RedissonProperties redissonProperties) {
        Config config = new Config();
        try {
            String address = redissonProperties.getAddress();
            String password = redissonProperties.getPassword();
            int database = redissonProperties.getDatabase();
            String[] addrTokens = address.split(",");
            String masterNodeAddr = addrTokens[0];
            /**设置主节点ip*/
            config.useMasterSlaveServers().setMasterAddress(masterNodeAddr);
            if (StringUtils.isNotBlank(password)) {
                config.useMasterSlaveServers().setPassword(password);
            }
            config.useMasterSlaveServers().setDatabase(database);
            /**设置从节点，移除第一个节点，默认第一个为主节点*/
            List<String> slaveList = new ArrayList<>();
            for (String addrToken : addrTokens) {
                slaveList.add(GlobalConstant.REDIS_CONNECTION_PREFIX.getConstant_value() + addrToken);
            }
            slaveList.remove(0);

            config.useMasterSlaveServers().addSlaveAddress((String[]) slaveList.toArray());
            LOGGER.info("初始化[MASTERSLAVE]方式Config,redisAddress:" + address);
        } catch (Exception e) {
            LOGGER.error("MASTERSLAVE Redisson init error", e);
            e.printStackTrace();
        }
        return config;
    }
}
