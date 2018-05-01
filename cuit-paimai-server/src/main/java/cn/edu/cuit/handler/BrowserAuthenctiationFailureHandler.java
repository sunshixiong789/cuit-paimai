/**
 *
 */
package cn.edu.cuit.handler;

import cn.edu.cuit.properties.CuitProperties;
import cn.edu.cuit.properties.LoginTpye;
import cn.edu.cuit.common.CommonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 浏览器登录失败处理器
 *
 * @author sunshixiong
 */
@Component("browserAuthenctiationFailureHandler")
public class BrowserAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {


    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CuitProperties cuitProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        if (LoginTpye.JSON.equals(cuitProperties.getBrower().getLoginTpye())) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            CommonResult result = new CommonResult();
            result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            result.setSuccess(false);
            result.setMessage("登录失败" + exception.getMessage());
            response.getWriter().write(objectMapper.writeValueAsString(result));
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }

    }

}
