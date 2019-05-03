package com.pxl.pay.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* Created by Mybatis Generator 2019/04/13
*/
@Data
public class OrderInfo implements Serializable {
    /**
	* 主键
	*/
    private Long orderId;

    /**
	* 用户id
	*/
    private Long accountId;

    /**
	* 商品id
	*/
    private Long commodityId;

    /**
	* 商品数量
	*/
    private Integer commodityCount;

    /**
	* 支付状态
	*/
    private Integer payStatus;

    /**
	* 创建时间
	*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
	* 更新时间
	*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}