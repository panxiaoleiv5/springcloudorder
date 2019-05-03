package com.pxl.order.service;

import com.pxl.order.entity.OrderInfo;

/**
 * @author pxl
 * @description
 * @date 2019/4/12 18:49
 */
public interface OrderService {
    /**
    * 创建订单
    * @author pxl
    * @date 2019/4/12 18:50
    * @param accountId
    * @param commodityId
    * @param commodityCount
    * @return void
    **/
    void createOrder(Long accountId, Long commodityId, Integer commodityCount);

    /**
    * 通过主键获取订单
    * @author pxl
    * @date 2019/4/14 13:17
    * @param orderId
    * @return com.pxl.order.entity.OrderInfo
    **/
    OrderInfo getOrderById(Long orderId);

    /**
    * 更新订单支付状态
    * @author pxl
    * @date 2019/4/14 13:18
    * @param orderId
    * @param status
    * @return int
    **/
    int updatePaymentStatusOfOrder(OrderInfo orderInfo);
}
