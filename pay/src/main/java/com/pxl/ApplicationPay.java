package com.pxl;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fescar.rm.datasource.DataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author pxl
 * @description
 * @date 2019/4/12 9:31
 */
@EnableFeignClients
@SpringCloudApplication
@EnableHystrixDashboard
public class ApplicationPay {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationPay.class, args);
    }

    @Primary
    @Bean("dataSource")
    public DataSourceProxy dataSource(Environment environment) throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(environment.getProperty("spring.datasource.url"));
        druidDataSource.setUsername(environment.getProperty("spring.datasource.username"));
        druidDataSource.setPassword(environment.getProperty("spring.datasource.password"));
        druidDataSource.setDriver(DriverManager.getDriver(environment.getProperty("spring.datasource.url")));
        return new DataSourceProxy(druidDataSource);
    }

}
