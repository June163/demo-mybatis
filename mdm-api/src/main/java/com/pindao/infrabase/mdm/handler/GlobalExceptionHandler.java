package com.pindao.infrabase.mdm.handler;

import com.pindao.common.sdk.domain.vo.ApiResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : wangyongkang
 * @description : 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 错误码
     */
    private final int ERROR_CODE = -1;

    /**
     * 错误提示
     */
    private final String ERROR_STR = "未知错误";

    /**
     * 基础异常
     */
    @ExceptionHandler(Exception.class)
    public ApiResult baseException(Exception e) {
        log.error(e.getMessage(), e);
        if (StringUtils.isBlank(e.getMessage())) {
            return ApiResult.failure(ERROR_CODE, ERROR_STR);
        }
        return ApiResult.failure(ERROR_CODE, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        return ApiResult.failure(ERROR_CODE, e.getBindingResult().getFieldError().getDefaultMessage());
    }
}
