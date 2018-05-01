package cn.edu.cuit.model;

import cn.edu.cuit.common.CommonJsonView;
import cn.edu.cuit.validator.TypeValid;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


/**
 * Table:
 * @author sunshixiong on 2018/01/30.
 */
@Entity
@Data
public class CuitAdmin implements Serializable {

    private static final long serialVersionUID = -6537258515735650788L;
	@Id
	@GeneratedValue
	@JsonView(CommonJsonView.SimpleView.class)
   	private Integer id;

	@NotBlank(message = "登录名不能为空")
	@JsonView(CommonJsonView.SimpleView.class)
	private String name;

	@NotBlank(message = "密码不能为空")
	@JsonView(CommonJsonView.DetailView.class)
	private String passWord;

	@TypeValid
	@JsonView(CommonJsonView.DetailView.class)
	private String type;

	private String email;

	private String mobile;

	private String sex;
}