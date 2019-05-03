package com.pxl.pay.service.feign;


import com.pxl.common.dto.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author pxl
 * @description
 * @date 2019/4/12 14:54
 */
@FeignClient(name = "${feign.remote.commodity-service}", path = "/commodity")
public interface CommodityFeignService {
    /**
    * 通过商品id获取商品
    * @author pxl
    * @date 2019/4/12 14:56
    * @param commodityId
    * @return com.pxl.commodity.entity.CommodityEntity
    **/
    @RequestMapping("/getCommodityById")
    ResultData getCommodityById(@RequestParam("commodityId") Long commodityId);

    /**
    * 更新商品
    * @author pxl
    * @date 2019/4/13 22:04
    * @param commodityId
    * @param commodityName
    * @param commodityPrice
    * @param inventory
    * @return com.pxl.common.dto.ResultData
    **/
    @RequestMapping("/updateCommodity")
    ResultData updateCommodity(@RequestParam("commodityId") Long commodityId, @RequestParam("commodityName") String commodityName, @RequestParam("commodityPrice") BigDecimal commodityPrice, @RequestParam("inventory") Integer inventory);
}
