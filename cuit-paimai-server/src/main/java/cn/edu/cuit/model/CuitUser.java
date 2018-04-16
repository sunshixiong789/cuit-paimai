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
public class CuitUser implements Serializable {

    private static final long serialVersionUID = -7102080331735056066L;

	@Id
	@GeneratedValue
   	private Integer id;
	private String userName;
	private String passWord;
	private String name;
	private String email;
	private String mobile;
	private String photo;
	private String birthday;
	private String cteatTime;
	private String authority;
}