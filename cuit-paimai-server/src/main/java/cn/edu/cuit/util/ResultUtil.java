package cn.edu.cuit.util;

import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import org.springframework.http.HttpStatus;

/**
 * 公共返回类处理工具包
 * @author sunshixiong
 * @date 2018/2/2 9:44
 */
public class ResultUtil {

    public static CommonResult success(Object object){
        CommonResult result = new CommonResult();
        result.setCode(HttpStatus.OK.value());
        result.setMessage("成功");
        result.setSuccess(true);
        result.setData(object);
        return result;
    }
    public static CommonResult error(HttpStatus httpStatus,String message){
        CommonResult result = new CommonResult();
        result.setCode(httpStatus.value());
        result.setMessage(message);
        result.setSuccess(false);
        return result;
    }
    public static CommonResult success(){
        CommonResult result = new CommonResult();
        result.setCode(HttpStatus.OK.value());
        result.setMessage("成功");
        result.setSuccess(true);
        return result;
    }
}
