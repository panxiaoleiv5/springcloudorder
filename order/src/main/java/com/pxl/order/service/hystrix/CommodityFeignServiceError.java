package com.pxl.order.service.hystrix;

import com.pxl.common.dto.ResultData;
import com.pxl.order.service.feign.CommodityFeignService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author pxl
 * @description
 * @date 2019/4/21 21:53
 */
@Component("commodityFeignServiceError")
public class CommodityFeignServiceError implements CommodityFeignService {
    @Override
    public ResultData getCommodityById(Long commodityId) {
        return new ResultData(500, "获取商品异常");
    }

    @Override
    public ResultData updateCommodity(Long commodityId, String commodityName, BigDecimal commodityPrice, Integer inventory) {
        return new ResultData(500, "更新商品异常");
    }
}
