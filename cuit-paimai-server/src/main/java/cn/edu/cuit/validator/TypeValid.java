package cn.edu.cuit.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义验证注解
 * @author sunshixiong
 * @date 2018/2/2 13:06
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TypeConstraintValidator.class)
public @interface TypeValid {
    String message() default "{必须是user或者admin}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
