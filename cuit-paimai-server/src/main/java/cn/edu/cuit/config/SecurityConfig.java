package cn.edu.cuit.config;


import cn.edu.cuit.handler.BrowserAuthenctiationFailureHandler;
import cn.edu.cuit.handler.BrowserAuthenticationSuccessHandler;
import cn.edu.cuit.handler.CuitLogoutSuccessHandler;
import cn.edu.cuit.properties.CuitProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author sunshixiong
 * @date 2018/2/28 16:09
 */
@Configuration
/*@EnableWebSecurity*/
@EnableGlobalMethodSecurity(securedEnabled = true,jsr250Enabled = true,prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    BrowserAuthenticationSuccessHandler successHandler;
    @Autowired
    BrowserAuthenctiationFailureHandler failureHandler;

    @Autowired
    private CuitProperties cuitProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage(cuitProperties.getBrower().getLoginPage())
                .loginProcessingUrl("/form/login")
                .successHandler(successHandler)
                .failureHandler(failureHandler).failureUrl("/login?error=false")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessHandler(new CuitLogoutSuccessHandler())
                .and()
                .authorizeRequests()
                .antMatchers("/**/*.js","/**/*.css","/**/*.png","/**/*.jpg","/**/fonts/**").permitAll()
                .antMatchers("/index/**","/assets/**","/static/**").permitAll()
                .antMatchers("/shop/**").permitAll()
                .antMatchers("/cuitUser","/form/login","/login_in","/login","/","/register","/logout","/cuitfile/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();//关掉这个跨站请求伪造才能使用postman测试api

    }
}
