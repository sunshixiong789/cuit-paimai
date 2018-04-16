package cn.edu.cuit.controller;

import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.model.CuitAnnouncement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunshixiong
 * @date 2018/4/14 19:57
 */
@Slf4j
@RestController
public class CuitLoginController {

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @GetMapping(value = "/login_in")
    public CommonResult loginIn(){
        CommonResult result = new CommonResult();
        result.setCode(401);
        result.setMessage("没有使用授权方式访问");
        return result;
    }
    @GetMapping(value = "/user/info")
    public Object getUserInfo(@AuthenticationPrincipal UserDetails userDetails){
        return userDetails;
    }
    @PostMapping(value = "/form/sunshixong")
    public String formLogin(CuitAnnouncement cuitForm){
        return "nihao";
    }
}
