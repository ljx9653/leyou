package com.ljx.springboot.configuration.springConfiguration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author lijx
 * @date 2019/11/27 - 10:17
 */
//声明一个类是一个java配置类，相当于一个xml配置文件
@Configuration
//读取资源文件
@PropertySource("classpath:springConfiguration/jdbc.properties")
//spring不允许同名的bean，即使在不同包也不行，因此通过此注解为重名类更改一个bean的名字
@Component("jdbcConfig")
public class JdbcConfiguration {
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.driverClassName}")
    String driverClassName;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;

    //把方法的返回值注入spring容器
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        //this代表全局变量，与局部变量做区分
        dataSource.setUrl(this.url);
        dataSource.setDriverClassName(this.driverClassName);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        return dataSource;
    }

//    public static void main(String[] args) {
//        URL resource = JdbcConfiguration.class.getResource("/");
//        System.out.println(resource);
//        System.out.println(resource.getFile());
//    }
}
