package com.pxl.gateway.controller;

import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author pxl
 * @description
 * @date 2019/4/10 9:37
 */
@RestController
public class HealthCheckController {
    //RequestMapping中的url地址需和配置文件中保持一致
    @RequestMapping("/healths")
    public String healthCheck(){
        return "ok";
    }

    @Test
    public void method1(){
        int j = 0;
        for (int i = 0;i < 100;i++){
            j++;
            System.out.println(j);
        }
    }

    private void method2() {
        System.out.println("method 2");
    }
}
