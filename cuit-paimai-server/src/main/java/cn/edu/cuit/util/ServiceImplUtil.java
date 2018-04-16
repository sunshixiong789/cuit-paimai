package cn.edu.cuit.util;

import cn.edu.cuit.cuitpaimairesource.common.CommonCRUD;
import cn.edu.cuit.cuitpaimairesource.common.CommonException;
import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

/**
 *service增删改静态工具类
 * @author sunshixiong
 * @date 2018/2/5 10:36
 */
@Slf4j
public class ServiceImplUtil {

    /**
     *增删改操作，｛删除传入参数必须是完整的model，其它可以为空或null，但是id必须有｝
     *      ｛save方法可以不传入id,但是修改的时候必须有id,如果id找不到，会增加一条数据｝
     * @param jpaRepository
     * @param entity
     * @param commonCRUD
     * @return
     */
    public static CommonResult doCRUD(JpaRepository jpaRepository, Object entity, CommonCRUD commonCRUD){
        CommonResult result;
        try {
            switch (commonCRUD.value()){
                case 1:
                    jpaRepository.save(entity);break;
                case 2:
                    jpaRepository.save(entity);break;
                case 3:
                    jpaRepository.delete(entity);break;
                default:
                       throw  new CommonException(HttpStatus.INTERNAL_SERVER_ERROR,"没有这个方法");

            }
            result = ResultUtil.success();
        } catch (Exception e) {
            log.error(commonCRUD.message(),e);
            //抛出异常方便事务管理，并且会被RestExceptionHandler自动处理
            throw new CommonException(HttpStatus.INTERNAL_SERVER_ERROR,commonCRUD.message());
        }
        return result;
    }
}
