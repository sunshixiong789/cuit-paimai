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
public class CuitTodaySpecial implements Serializable {

    private static final long serialVersionUID = -7223886272783158572L;

	@Id
	@GeneratedValue
   	private Integer id;
	private Timestamp startTime;
	private Timestamp endTime;
	private Integer cuitCommodityId;
}