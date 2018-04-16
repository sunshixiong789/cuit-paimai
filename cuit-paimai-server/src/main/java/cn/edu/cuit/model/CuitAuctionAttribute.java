package cn.edu.cuit.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


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
	private String startTime;
	private String endTime;
	private Integer cuitCommodityId;
}