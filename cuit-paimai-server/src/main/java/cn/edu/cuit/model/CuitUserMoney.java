package cn.edu.cuit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户金钱
 * @author sunshixiong
 * @date 2018/3/27 10:13
 */
@Data
@Entity
public class CuitUserMoney implements Serializable {

    private static final long serialVersionUID = 840429516458420280L;
    @Id
    @GeneratedValue
    private Integer id;

    private String userId;

    private String money;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp updateTime;
}
