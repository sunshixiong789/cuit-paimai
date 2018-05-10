package cn.edu.cuit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * Table:
 * @author sunshixiong on 2018/01/30.
 */
@Entity
@Data
public class CuitCommodity implements Serializable {

    private static final long serialVersionUID = -7182996043590789750L;
	@Id
	@GeneratedValue
   	private Integer id;
	private String name;
	private String picture;
	private String presentPrice;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Timestamp insertTime;
	private Timestamp startTime;
	private String status;
	private Integer cuitKindId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Timestamp endTime;
	private String pictureUuid;
}