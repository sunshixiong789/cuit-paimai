package cn.edu.cuit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author sunshixiong
 * @date 2018/4/17 9:58
 */
@Entity
@Data
public class CuitCommodityHistory implements Serializable {
    private static final long serialVersionUID = -385836571483331244L;

    @Id
    @GeneratedValue
    private Integer id;

    private String commodityName;

    private String price;

    private String baozhengjing;

    private String stare;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp buyTime;

    private String sellerName;
}
