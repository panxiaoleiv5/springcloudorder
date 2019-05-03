package com.pxl.commodity.service;

import com.pxl.commodity.entity.Commodity;

/**
 * @author pxl
 * @description
 * @date 2019/4/12 14:54
 */
public interface CommodityService {
    /**
    * 通过商品id获取商品
    * @author pxl
    * @date 2019/4/12 14:56
    * @param commodityId
    * @return com.pxl.commodity.entity.CommodityEntity
    **/
    Commodity getCommodityById(Long commodityId);

    int updateCommodity(Commodity commodity);
}
