package com.ljx.springboot.configuration.springbootConfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lijx
 * @date 2019/11/27 - 10:16
 */
//此注解不提供读取资源文件的功能，而是直接读取application.properties
@ConfigurationProperties(prefix="jdbc")
public class JdbcProperties {

    //不需要使用@Value,只需要指定前缀，springboot自动通过set方法注入对应的属性
    String url;
    String driverClassName;
    String username;
    String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
