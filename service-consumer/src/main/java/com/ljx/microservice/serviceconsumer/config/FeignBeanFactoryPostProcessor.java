package com.ljx.microservice.serviceconsumer.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Arrays;

/**
 * @author lijx
 * @date 2020/10/3 - 11:01
 *
 * 此类的作用是为了解决一个由devtools引发的feign重复注册的问题，文章地址https://blog.csdn.net/annotation_yang/article/details/82877433
 * 但测试发现，只能在工程重启后，自动热部署之前不报错，如果发生热部署，还是会报错，
 * 猜测feign和devtools不兼容，只能在配置文件中关掉devtools的自动热部署，改为手动热部署
 *
Error creating bean with name 'org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.springframework.core.env.ConfigurableEnvironment' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}

Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.springframework.core.env.ConfigurableEnvironment' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}

 */
//@Component
//在关闭自动热部署之后，此类已失去了作用
@Deprecated
public class FeignBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if (containsBeanDefinition(beanFactory, "feignContext", "eurekaAutoServiceRegistration")) {
            BeanDefinition bd = beanFactory.getBeanDefinition("feignContext");
            bd.setDependsOn("eurekaAutoServiceRegistration");
        }
    }

    private boolean containsBeanDefinition(ConfigurableListableBeanFactory beanFactory, String... beans) {
        return Arrays.stream(beans).allMatch(b -> beanFactory.containsBeanDefinition(b));
    }
}