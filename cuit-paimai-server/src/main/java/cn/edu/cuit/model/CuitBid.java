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
 * @date 2018/4/25 22:07
 */
@Entity
@Data
public class CuitBid implements Serializable {
    private static final long serialVersionUID = -426493307400516086L;

    @Id
    @GeneratedValue
    private int id;
    private String bidPrice;
    private int commodityId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp insertTime;
    private int userId;

}
