package cn.edu.cuit.cuitpaimairesource.common;

import org.springframework.http.HttpStatus;

/**
 * @author sunshixiong
 * @date 2018/2/2 10:28
 */
public class CommonException extends RuntimeException {
    private HttpStatus code;

    public CommonException(HttpStatus code,String message){
        super(message);
        this.code = code;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }
}
