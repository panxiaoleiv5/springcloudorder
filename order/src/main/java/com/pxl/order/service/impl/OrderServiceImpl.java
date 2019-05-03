package com.pxl.order.service.impl;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pxl.common.dto.ResultData;
import com.pxl.order.dao.OrderInfoMapper;
import com.pxl.order.entity.Commodity;
import com.pxl.order.entity.OrderInfo;
import com.pxl.order.service.OrderService;
import com.pxl.order.service.feign.CommodityFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

/**
 * @author pxl
 * @description
 * @date 2019/4/12 18:49
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CommodityFeignService commodityFeignService;
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    @GlobalTransactional
    public void createOrder(Long accountId, Long commodityId, Integer commodityCount) {
        ResultData resultData = commodityFeignService.getCommodityById(commodityId);
        if (resultData.getCode().equals(500)){
            throw new RuntimeException(resultData.getDescription());
        }
        Map maps = (Map) resultData.getData();

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String str = gson.toJson(maps);
        Commodity commodity = gson.fromJson(str, Commodity.class);

        if (commodity.getInventory() < commodityCount){
            throw new RuntimeException("商品库存不足");
        }

        resultData = commodityFeignService.updateCommodity(commodity.getCommodityId(), null, null, commodity.getInventory()-commodityCount);
        if (resultData.getCode().equals(500)){
            throw new RuntimeException(resultData.getDescription());
        }

        OrderInfo order = new OrderInfo();
        order.setAccountId(accountId);
        order.setCommodityId(commodityId);
        order.setCommodityCount(commodityCount);
        order.setPayStatus(0);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        orderInfoMapper.insert(order);

    }

    @Override
    public OrderInfo getOrderById(Long orderId) {
        return orderInfoMapper.selectByPrimaryKey(orderId);
    }

    @Override
    @Transactional
    public int updatePaymentStatusOfOrder(OrderInfo orderInfo) {
        return orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
    }
}
