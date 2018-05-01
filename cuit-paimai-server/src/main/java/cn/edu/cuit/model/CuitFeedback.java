package cn.edu.cuit.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author sunshixiong
 * @date 2018/4/30 15:46
 */
@Data
@Entity
public class CuitFeedback implements Serializable {


    private static final long serialVersionUID = 6459579668437174863L;
    @Id
    @GeneratedValue
    private Integer id;

    private Integer commodityId;

    private String commodityName;

    private Integer userId;

    private String userName;

    private String email;

    private String feedbackInformation;

    private Timestamp insertTime;
}
