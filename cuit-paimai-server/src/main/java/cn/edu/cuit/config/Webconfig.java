package cn.edu.cuit.config;

import cn.edu.cuit.filter.ControllerFilter;
import cn.edu.cuit.interceptor.TimeInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 配置类：可以配置第三方过滤器，配置拦截器等，@Configuration作用是把这个类声明为配置类
 * @author sunshixiong
 * @date 2018/2/4 16:23
 */
/*@Configuration*/
public class Webconfig implements WebMvcConfigurer {

    @Resource
    private TimeInterceptor interceptor;

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }

    /**
     * 注册过滤器的配置bean
     * @return
     */
    @Bean
    public FilterRegistrationBean controllerFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        ControllerFilter filter = new ControllerFilter();
        registrationBean.setFilter(filter);
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);
        return registrationBean;
    }
}
