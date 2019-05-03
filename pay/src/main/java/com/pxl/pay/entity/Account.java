package com.pxl.pay.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
* Created by Mybatis Generator 2019/04/13
*/
@Data
public class Account implements Serializable {
    /**
	* 主键
	*/
    private Long accountId;

    /**
	* 用户名称
	*/
    private String accountName;

    /**
	* 账户余额
	*/
    private BigDecimal balance;

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