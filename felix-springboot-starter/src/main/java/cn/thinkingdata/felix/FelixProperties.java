package cn.thinkingdata.felix;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * class_name: FelixProperties
 * package: cn.thinkingdata.felix
 * describe: 类加载需要的配置文件
 * creat_user: felix@thinkingdata.cn
 * creat_date: 2020/4/14
 * creat_time: 9:37 下午
 **/
@ConfigurationProperties(prefix="felix")
public class FelixProperties {


    private String name;
    private String msg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
