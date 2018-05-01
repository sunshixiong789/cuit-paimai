package cn.edu.cuit.util;

import cn.edu.cuit.common.CommonException;
import cn.edu.cuit.common.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *处理控制层异常
 * @author sunshixiong
 * @date 2018/2/2 10:13
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResult handle(Exception e){
        if(e instanceof CommonException){
            CommonException exception = (CommonException) e;
            return ResultUtil.error(exception.getCode(),exception.getMessage());
        }
        return ResultUtil.error(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
    }
}
