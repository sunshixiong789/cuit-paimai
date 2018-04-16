package cn.edu.cuit.validator;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义数据校验
 * @author sunshixiong
 * @date 2018/2/2 13:11
 */
@Slf4j
public class TypeConstraintValidator implements ConstraintValidator<TypeValid,Object> {
    @Override
    public void initialize(TypeValid constraintAnnotation) {
        log.info("自定义验证初始化成功");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if("user".equals(value)||"admin".equals(value)){
            return true;
        }
        else {
            return false;
        }
    }
}
