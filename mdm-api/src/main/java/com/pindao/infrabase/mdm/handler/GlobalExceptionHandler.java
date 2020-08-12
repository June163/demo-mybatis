package com.pindao.infrabase.mdm.handler;

import com.pindao.common.sdk.domain.vo.ApiResult;
import com.pindao.common.sdk.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

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
    private static final int ERROR_CODE = -1;

    /**
     * 错误提示
     */
    private static final String ERROR_STR = "未知错误";

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public ApiResult baseException(Exception e) {
        log.error(e.getMessage(), e);
        return ApiResult.failure(ERROR_CODE, ERROR_STR);
    }

    /**
     * 自定义业务异常-2
     */
    @ExceptionHandler(BizException.class)
    public ApiResult bizException(BizException e) {
        log.error(e.getMessage(), e);
        return ApiResult.failure(ERROR_CODE, e.getMessage());
    }

    /**
     * 统一捕获 404
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ApiResult handlerNoFoundException(NoHandlerFoundException e) {
        log.error(e.getMessage(), e);
        return ApiResult.failure(ERROR_CODE, "路径不存在，请检查路径是否正确");
    }

    /**
     * 参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResult methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        return ApiResult.failure(ERROR_CODE, e.getBindingResult().getFieldError().getDefaultMessage());
    }
}
