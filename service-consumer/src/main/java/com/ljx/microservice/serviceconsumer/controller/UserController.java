package com.ljx.microservice.serviceconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author lijx
 * @date 2019/12/19 - 14:46
 */
@RestController
@RequestMapping("consumer/user")
//定义全局的降级方法，注意：在这里定义了之后，类中方法不加@HystrixCommand是无法使用全局降级方法的，如果不行使用全局降级方法，可以在@HystrixCommand中指定自己的fallbackMethod
@DefaultProperties(defaultFallback = "defaultFallbackMethod")
@SuppressWarnings("all")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    //可以通过discoveryClient拉取服务列表，查看所有的服务信息
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping
    //指定降级方法
    @HystrixCommand(fallbackMethod = "queryUserByIdFallback")
    //进行降级方法的改造，在业务层面，降级方法返回User对象是不合适的，因此返回值改为String
    //public User queryUserById(@RequestParam("id") Long id){
    public String queryUserById(@RequestParam("id") Long id) {
        //注意此处硬编码，后期要进行改造
        //User user = this.restTemplate.getForObject("http://localhost:8081/user/" + id, User.class);
        /**
         * 服务消费方硬编码改造，改成eureka的地址
         */
        //通过服务名获取服务实例，由于微服务可能是一个集群，因此返回一个list
        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        //我们只有一个实例因此使用0,这样我们就能获得服务实例的信息，如ip、端口等
        /*ServiceInstance providerserviceInstance = instances.get(0);
        User user = this.restTemplate.getForObject("http://"+providerserviceInstance.getHost()+":"+providerserviceInstance.getPort()+"/user/" + id, User.class);*/
        //不再使用上面那种通过拼接url的方式，而是用服务名代替原来的ip和port，ribbon会自动解析服务名，并找到合适的服务实例进行调用
        String baseUrl = "http://service-provider/user/" + id;
        /*User user = this.restTemplate.getForObject(baseUrl, User.class);
        return user; //进行降级方法的改造*/
        return this.restTemplate.getForObject(baseUrl, String.class);
    }

    @HystrixCommand
    @RequestMapping("test1")
    public String method1() {
        try {
            //降级时间为6s，手动触发降级
            Thread.sleep(7000);
        } catch (InterruptedException e) {
        }
        return "使用全局降级方法";
    }

    @RequestMapping("test2")
    public String method2() {
        return "不使用降级方法";
    }

    //全局降级方法，注意参数列表要为空，返回参数保持一致
    public String defaultFallbackMethod() {
        return "全局降级方法触发";
    }

    //指定方法的降级方法，要求：参数列表和返回值需要和原方法一致
    public String queryUserByIdFallback(Long id) {
        return "服务正忙，请稍后再试";
    }
}
