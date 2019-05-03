package com.pxl;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fescar.rm.datasource.DataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author pxl
 * @description
 * @date 2019/4/11 22:54
 */
@SpringCloudApplication
public class ApplicationAccount {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationAccount.class, args);
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
