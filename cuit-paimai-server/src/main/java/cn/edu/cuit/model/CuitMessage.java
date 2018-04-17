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
public class CuitMessage implements Serializable {

    private static final long serialVersionUID = -8954724997633575610L;

	@Id
	@GeneratedValue
   	/** 用户消息Id */
	private Integer id;
	/** 消息头 */
	private String messageHeader;
	/** 消息体 */
	private String messageBody;
	/** '发送者' */
	private Integer sender;
	/** 接收者 */
	private Integer receiver;
	/** 发送时间*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Timestamp insertTime;
}