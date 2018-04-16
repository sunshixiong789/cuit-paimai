package cn.edu.cuit.model;

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
	private String insertTime;
	private String status;
	private Integer cuitKindId;
	private Timestamp endTime;
}