package cn.thinkingdata.felix;


/**
 * class_name: FelixService
 * package: cn.thinkingdata.felix
 * describe: 对外提供服务的类
 * creat_user: felix@thinkingdata.cn
 * creat_date: 2020/4/14
 * creat_time: 9:37 下午
 **/
public class FelixService {


    private FelixProperties felixProperties;

    public FelixService(FelixProperties felixProperties) {
        this.felixProperties = felixProperties;
    }

    public String sayHello() {
        return "felix say: " + felixProperties.getName() + " , " + felixProperties.getMsg();
    }
}
