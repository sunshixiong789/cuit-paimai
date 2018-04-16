package cn.edu.cuit;

import com.didispace.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableSwagger2Doc
public class CuitPaimaiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuitPaimaiServerApplication.class, args);
	}
}
