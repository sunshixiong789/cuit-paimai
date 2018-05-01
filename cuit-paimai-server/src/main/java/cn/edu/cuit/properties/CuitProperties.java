package cn.edu.cuit.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author sunshixiong
 * @date 2018/3/16 17:42
 */
@Component
@ConfigurationProperties(prefix = "cuit.security")
public class CuitProperties {
    private BrowerProperties brower;

    public BrowerProperties getBrower() {
        return brower;
    }

    public void setBrower(BrowerProperties brower) {
        this.brower = brower;
    }
}
