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
public class CuitDescribe implements Serializable {

    private static final long serialVersionUID = -8207802620389151684L;
	@Id
	@GeneratedValue
   	private Integer id;
	private String commodityUuid;
	private String taskNumber;
	private String charity;
	private String style;
	private String grain;
	private String weight;
	private String appraisalMarks;
	private String identification;
	private String orea;
	private String certificationAuthority;
	private String authorityWebsite;
	private String reportNumber;
	private String kindof;
	private String orientation;
	private String appearance;
}