package com.pxl;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author pxl
 * @description
 * @date 2019/4/12 10:31
 */
@SpringCloudApplication
@EnableConfigServer
public class ApplicationConfig {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class, args);
    }
}
