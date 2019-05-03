package com.pxl.commodity.controller;

import com.pxl.commodity.entity.Commodity;
import com.pxl.commodity.service.CommodityService;
import com.pxl.common.constants.Constants;
import com.pxl.common.dto.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author pxl
 * @description
 * @date 2019/4/12 14:52
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    CommodityService commodityService;

    @RequestMapping("/getCommodityById")
    public ResultData getCommodityById(@RequestParam("commodityId") Long commodityId){
        Commodity commodity = commodityService.getCommodityById(commodityId);
        ResultData resultData = new ResultData(Constants.SUCCESS, "获取商品成功");
        resultData.setData(commodity);
        return resultData;
    }

    @RequestMapping("/updateCommodity")
    public ResultData updateCommodity(Long commodityId, String commodityName, BigDecimal commodityPrice, Integer inventory){
        Commodity commodity = new Commodity();
        commodity.setCommodityName(commodityName);
        commodity.setCommodityPrice(commodityPrice);
        commodity.setInventory(inventory);
        commodity.setCommodityId(commodityId);
        int flag = commodityService.updateCommodity(commodity);
        if (flag == 1){
            return new ResultData(Constants.SUCCESS, "更新商品成功");
        } else {
            return new ResultData(Constants.ERROR, "更新商品失败");
        }

    }
}
