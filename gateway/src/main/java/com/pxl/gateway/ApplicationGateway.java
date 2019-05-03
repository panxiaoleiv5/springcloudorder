package com.pxl.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author pxl
 * @description
 * @date 2019/4/17 16:51
 */
@SpringCloudApplication
public class ApplicationGateway {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationGateway.class, args);
    }
}
