package cn.edu.cuit.aspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 切片获取api执行时间
 * @author sunshixiong
 * @date 2018/2/5 17:06
 */
/*@Component*/
@Aspect
@Slf4j
public class TimeAspect {

    /**
     * {@before 表示这个方法在执行前执行，@after在执行后执行，@Around能兼容前面几个包括@afterthrow}
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "execution(* cn.edu.cuit.controller.*.*(..))")
    public Object controllerAop(ProceedingJoinPoint pjp) throws Throwable {
        log.info("切片执行开始前");
        Object[] args = pjp.getArgs();
        for(Object arg:args){
            log.info((arg.toString()));
        }
        long start = System.currentTimeMillis();
        Object object = pjp.proceed();
        log.info("方法耗时 ："+(System.currentTimeMillis()-start));
        log.info("切片结束");
        return object;
    }
}
