package cn.edu.cuit.cuitpaimairesource.common;

import java.io.Serializable;

/**
 * @author sunshixiong
 * @date 2018/1/30 16:50
 */
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = -7268040542410707954L;
    private boolean success = false;
    private String message;
    private T data;
    private int code;

    public CommonResult() {
    }

    public CommonResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public CommonResult(boolean success) {
        this.success = success;
    }

    public CommonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
