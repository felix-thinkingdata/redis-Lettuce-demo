package cn.thinkingdata.controller;

import cn.thinkingdata.felix.FelixService;
import cn.thinkingdata.redis.RedissonLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {


    @Autowired
    RedissonLock redissonLock;

    @Autowired
    FelixService felixService;

  /**
   * describe: 获取锁
   * creat_user: felix@thinkingdata.cn
   * creat_date: 2020/4/14
   * creat_time: 4:20 下午
   **/
    @GetMapping("/lock")
    public Boolean lock() {
        return redissonLock.lock("lock", 100);
    }



  /**
   * describe: 释放锁
   * creat_user: felix@thinkingdata.cn
   * creat_date: 2020/4/14
   * creat_time: 4:19 下午
   **/
    @GetMapping("/release")
    public void release() {
         redissonLock.release("lock");
    }


    /**
     * describe: 测试自动装填felix starter
     * creat_user: felix@thinkingdata.cn
     * creat_date: 2020/4/14
     * creat_time: 10:21 下午
     **/
    @GetMapping("/felix")
    public String felixSay(){
       return felixService.sayHello();
    }



}
