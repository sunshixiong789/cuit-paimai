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
public class CuitKind implements Serializable {

    private static final long serialVersionUID = -4723908386777057323L;
	@Id
	@GeneratedValue
   	private Integer id;
	private String name;
	private String desc;
}