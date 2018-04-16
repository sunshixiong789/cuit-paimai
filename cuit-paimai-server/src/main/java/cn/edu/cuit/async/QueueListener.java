package cn.edu.cuit.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 *
 * @author sunshixiong
 * @date 2018/2/8 20:27
 */
@Slf4j
public class QueueListener implements ApplicationListener {
    @Autowired
    MockQueue mockQueue;
    @Autowired
    DeferredResultHolder resultHolder;

    /**
     * 模拟监听器
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        new Thread(() -> {
            while (true){
                if (StringUtils.isNotBlank(mockQueue.getCompleteOrder())){
                    String orderNumber = mockQueue.getCompleteOrder();
                    log.info("返回订单处理结果："+orderNumber);
                    resultHolder.getMap().get(orderNumber).setResult("订单成功");
                    mockQueue.setCompleteOrder(null);
                }else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
