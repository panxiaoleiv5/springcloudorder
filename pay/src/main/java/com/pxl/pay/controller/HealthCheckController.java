package com.pxl.pay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
