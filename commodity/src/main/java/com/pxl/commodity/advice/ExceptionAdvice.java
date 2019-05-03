package com.pxl.commodity.advice;

import com.pxl.common.constants.Constants;
import com.pxl.common.dto.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author pxl
 * @description
 * @date 2019/4/12 16:27
 */
@RestControllerAdvice(basePackages = "com.pxl.commodity.controller")
public class ExceptionAdvice {
    Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(value = {Exception.class,
    })
    public ResultData handleException(
            Throwable throwable) {
        logger.error("出现异常",throwable);
        ResultData resultData = new ResultData(Constants.ERROR, throwable.getMessage());
        return resultData;
    }
}
