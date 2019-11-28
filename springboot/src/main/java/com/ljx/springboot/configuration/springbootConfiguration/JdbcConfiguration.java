package com.ljx.springboot.configuration.springbootConfiguration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author lijx
 * @date 2019/11/27 - 10:17
 */
//声明一个类是一个java配置类，相当于一个xml配置文件
@Configuration
//如果不声明此注解，JdbcProperties将无法自动注入。此注解用于启用一个或多个属性读取类
@EnableConfigurationProperties(JdbcProperties.class)
//注释太多，使用此注解抑制警告
@SuppressWarnings("all")
public class JdbcConfiguration {

    //方式1：使用Autowired注入
//    @Autowired
//    private JdbcProperties jdbcProperties;

    //方式2：使用构造方法注入，此时jdbcProperties不需要@Autowired
//    public JdbcConfiguration(JdbcProperties jdbcProperties){
//        this.jdbcProperties = jdbcProperties;
//    }

    //把方法的返回值注入spring容器
//    @Bean
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        //this代表全局变量，与局部变量做区分
//        dataSource.setUrl(this.jdbcProperties.getUrl());
//        dataSource.setDriverClassName(this.jdbcProperties.getDriverClassName());
//        dataSource.setUsername(this.jdbcProperties.getUsername());
//        dataSource.setPassword(this.jdbcProperties.getPassword());
//        return dataSource;
//    }

//    @Bean
    //方式3：@Bean方法的形参注入，此时不需要jdbcProperties这个属性
//    public DataSource dataSource(JdbcProperties jdbc) {
//        DruidDataSource dataSource = new DruidDataSource();
//        //this代表全局变量，与局部变量做区分
//        dataSource.setUrl(jdbc.getUrl());
//        dataSource.setDriverClassName(jdbc.getDriverClassName());
//        dataSource.setUsername(jdbc.getUsername());
//        dataSource.setPassword(jdbc.getPassword());
//        return dataSource;
//    }

    //方式4：最优雅的方式，连JdbcProperties这个属性读取类都不需要了，方法形参和set字段的代码都不需要了，会自动调用DataSource的set方法为属性设值，
    @Bean
    @ConfigurationProperties(prefix="jdbc")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }
}
