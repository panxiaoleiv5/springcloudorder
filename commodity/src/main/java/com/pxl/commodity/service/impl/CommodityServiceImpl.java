package com.pxl.commodity.service.impl;

import com.pxl.commodity.dao.CommodityMapper;
import com.pxl.commodity.entity.Commodity;
import com.pxl.commodity.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pxl
 * @description
 * @date 2019/4/12 14:55
 */
@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    CommodityMapper commodityMapper;

    @Override
    public Commodity getCommodityById(Long commodityId) {
        return commodityMapper.selectByPrimaryKey(commodityId);
    }

    @Override
    @Transactional
    public int updateCommodity(Commodity commodity) {
        return commodityMapper.updateByPrimaryKeySelective(commodity);
    }
}
