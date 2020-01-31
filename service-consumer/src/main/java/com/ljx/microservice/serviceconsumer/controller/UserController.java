package com.ljx.microservice.serviceconsumer.controller;

import com.ljx.microservice.serviceconsumer.pojo.User;
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
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    //可以通过discoveryClient拉取服务列表，查看所有的服务信息
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping
    public User queryUserById(@RequestParam("id") Long id){
        //注意此处硬编码，后期要进行改造
//        User user = this.restTemplate.getForObject("http://localhost:8081/user/" + id, User.class);
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
        User user = this.restTemplate.getForObject(baseUrl, User.class);
        return user;
    }
}
