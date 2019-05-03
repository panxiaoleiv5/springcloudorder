package com.pxl.order.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
* Created by Mybatis Generator 2019/04/13
*/
@Data
public class Commodity implements Serializable {
    /**
	* 主键
	*/
    private Long commodityId;

    /**
	* 商品名称
	*/
    private String commodityName;

    /**
	* 商品价格
	*/
    private BigDecimal commodityPrice;

    /**
	* 库存
	*/
    private Integer inventory;

    /**
	* 创建时间
	*/
    private Date createTime;

    /**
	* 更新时间
	*/
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}