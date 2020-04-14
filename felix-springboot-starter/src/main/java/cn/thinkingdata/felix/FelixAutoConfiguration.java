package cn.thinkingdata.felix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//只有当特定的 class 在 classpath 上时, BeanDefination 才会被注册
@ConditionalOnClass(FelixService.class)
@EnableConfigurationProperties(FelixProperties.class)
@Configuration
public class FelixAutoConfiguration {


    @Autowired
    private FelixProperties felixProperties;

    @Bean
    @ConditionalOnMissingBean(FelixService.class)
    public FelixService felixService(){
        return new FelixService(felixProperties);
    }
}
