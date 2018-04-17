package cn.edu.cuit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 系统公告
 * @author sunshixiong
 * @date 2018/4/16 9:00
 */
@Entity
@Data
public class CuitAnnouncement implements Serializable {

    private static final long serialVersionUID = -2322107961947408520L;
    @Id
    @GeneratedValue
    private Integer id;

    private String header;

    private String boday;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp insertTime;

    private String insertUser;
}
