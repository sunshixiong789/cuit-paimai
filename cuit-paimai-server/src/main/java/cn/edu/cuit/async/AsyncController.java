package cn.edu.cuit.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * 多线程处理api
 * @author sunshixiong
 * @date 2018/2/6 20:22
 */
@RestController
@Slf4j
public class AsyncController {

    @Autowired
    MockQueue mockQueue;
    @Autowired
    DeferredResultHolder resultHolder;

    /**
     * 使用Callable来处理多线程，进入主线程后会立即执行主线程，而副线程不管执行 多久都不会影响主线程处理下一个请求
     * @return
     */
    @GetMapping(value = "/order")
    public Callable<String> order(){

        log.info("主线程开始");
         Callable<String> result = () -> {
             log.info("副线程开始");
             Thread.sleep(10000);
             log.info("副线程结束");
             return "success";
         };
         log.info("主线程返回");
         return result;
    }

    /**
     * 使用deferrdResult来处理多线程
     * @return
     */
    @GetMapping(value = "/deferred")
    public DeferredResult<String> deferredResult() {
        log.info("主线程开始");
        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);

        DeferredResult<String> result = new DeferredResult<>();
        resultHolder.getMap().put(orderNumber,result);
        log.info("主线程结束");
        return result;
    }
}
