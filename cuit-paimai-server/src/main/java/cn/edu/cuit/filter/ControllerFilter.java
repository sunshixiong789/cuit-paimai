package cn.edu.cuit.filter;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * 过滤器的实现（如果使用@component和@WebFilter就不用写配置bean）
 * @author sunshixiong
 * @date 2018/2/4 11:44
 */
/*@Component*/
/*@ServletComponentScan*/
@Slf4j
/*@WebFilter(urlPatterns = "/*")*/
public class ControllerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器初始化成功");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("过滤器开始时间：");
        long start = new Date().getTime();
        chain.doFilter(request,response);
        log.info("time filter:"+(new Date().getTime()-start));
        log.info("过滤器结束");
    }

    @Override
    public void destroy() {
        log.info("过滤器销毁");
    }
}
