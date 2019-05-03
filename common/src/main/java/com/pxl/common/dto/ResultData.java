package com.pxl.common.dto;

import lombok.Data;

/**
 * @author pxl
 * @description
 * @date 2019/4/12 15:26
 */
@Data
public class ResultData {
    private Integer code;

    private String description;

    private Object data;

    public ResultData() {
    }

    public ResultData(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public ResultData(Integer code, String description, Object data) {
        this.code = code;
        this.description = description;
        this.data = data;
    }
}
