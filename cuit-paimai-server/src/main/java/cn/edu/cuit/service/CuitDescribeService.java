package cn.edu.cuit.service;

import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.model.CuitDescribe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/4/16 21:32
 */
public interface CuitDescribeService {
    /**
     * 增加数据
     * @param entity
     * @return
     */
    CommonResult add(CuitDescribe entity);
    /**
     * 删除数据
     * @param entity
     * @return
     */
    CommonResult delete(CuitDescribe entity);
    /**
     * 修改数据
     * @param entity
     * @return
     */
    CommonResult update(CuitDescribe entity);

    /**
     * 查询数据
     * @param entity
     * @return
     */
    List<CuitDescribe> queryList(CuitDescribe entity);

    /**
     * 分页查询
     * @return
     */
    Page queryPage(CuitDescribe entity, Pageable pageable);

    /**
     * 通过商品查找描述
     * @param id
     * @return
     */
    List<CuitDescribe> listByCommodityId(Integer id);
}
