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
public class CuitBidHistory implements Serializable {

    private static final long serialVersionUID = -8640213901174406658L;
	@Id
	@GeneratedValue
   	private Integer id;
	private String price;
	private String cuitCommodityName;
	private String cuitUserName;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Timestamp endTime;
	private String end_price;
}