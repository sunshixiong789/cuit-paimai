package cn.edu.cuit.validator;

import cn.edu.cuit.cuitpaimairesource.common.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

/**
 * validate验证处理工具类
 * @author sunshixiong
 * @date 2018/2/2 17:43
 */
public class BindingResultUtil {

    public static void JudegResult(BindingResult results){
        if(results.hasErrors()){
            StringBuffer message = new StringBuffer();
            results.getAllErrors().stream().forEach(result -> {
                message.append(result.getDefaultMessage());
                message.append(",");
            } );
            throw new CommonException(HttpStatus.BAD_REQUEST,message.toString());
        }
    }
}
