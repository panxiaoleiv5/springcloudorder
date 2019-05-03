package com.pxl.pay.service.feign;

import com.pxl.common.dto.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author pxl
 * @description
 * @date 2019/4/14 12:36
 */
@FeignClient(name = "${feign.remote.order-service}", path = "/order")
public interface OrderFeignService {
    @RequestMapping("/getOrderById")
    ResultData getOrderById(@RequestParam("orderId") Long orderId);

    @RequestMapping("/updateOrder")
    ResultData updatePaymentStatusOfOrder(@RequestParam("orderId") Long orderId);
}
