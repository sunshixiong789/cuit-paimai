package cn.edu.cuit.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunshixiong
 * @date 2018/2/4 15:58
 */
@Slf4j
@Component
public class TimeInterceptor implements HandlerInterceptor {
    /**
     * 执行方法前调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("prehandle执行");
        log.info(((HandlerMethod)handler).getBean().getClass().getName());
        log.info(((HandlerMethod)handler).getMethod().getName());
        request.setAttribute("startTime",System.currentTimeMillis());
        return true;
    }

    /**
     * 执行controller方法后调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     * @deprecated 如果preHandle方法抛出异常这个不会被执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
        log.info("postHandle执行");
        long start = (long) request.getAttribute("startTime");
        log.info("消耗时间："+(System.currentTimeMillis()-start));
    }

    /**
     * 不管怎么这个方法都会被执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.info("afterCompletion执行");
        long start = (long) request.getAttribute("startTime");
        log.info("消耗时间："+(System.currentTimeMillis()-start));
        log.info("异常："+ex);
    }
}
