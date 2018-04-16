/**
 * 
 */
package cn.edu.cuit.cuitpaimaiapp.handler;

import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * app登录失败处理器`
 * @author sunshixiong
 *
 */
@Component("appAuthenctiationFailureHandler")
public class AppAuthenctiationFailureHandler implements AuthenticationFailureHandler {

	@Autowired
	private ObjectMapper objectMapper;
	

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setContentType("application/json;charset=UTF-8");
		CommonResult result = new CommonResult<>();
		result.setSuccess(false);
		result.setMessage("登录失败"+exception.getMessage());
		result.setCode(500);
		response.getWriter().write(objectMapper.writeValueAsString(result));
	}

}
