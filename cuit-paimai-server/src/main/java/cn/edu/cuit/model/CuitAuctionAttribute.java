package cn.edu.cuit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


/**
 * Table:
 * @author sunshixiong on 2018/01/30.
 */
@Entity
@Data
public class CuitAuctionAttribute implements Serializable {

    private static final long serialVersionUID = -9138634784239644871L;
	@Id
	@GeneratedValue
   	private Integer id;
	private String upsetPrice;
	private String bidIncrement;
	private String cashDeposit;
	private String commission;
	private String reservePrice;
	private String delayPeriod;
	private String auctionOrganization;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date startTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date endTime;
	private Integer cuitCommodityId;
}