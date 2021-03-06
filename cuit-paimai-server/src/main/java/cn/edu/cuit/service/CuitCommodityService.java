package cn.edu.cuit.service;

import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.model.CuitCommodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.List;

/**
 * 商品查询
 * @author sunshixiong
 * @date 2018/3/22 16:25
 */
public interface CuitCommodityService {
    /**
     * 增加数据
     * @param entity
     * @return
     */
    CommonResult add(CuitCommodity entity);
    /**
     * 删除数据
     * @param entity
     * @return
     */
    CommonResult delete(CuitCommodity entity);
    /**
     * 修改数据
     * @param entity
     * @return
     */
    CommonResult update(CuitCommodity entity);

    /**
     * 查询数据
     * @param entity
     * @return
     */
    List<CuitCommodity> queryList(CuitCommodity entity);

    /**
     * 分页查询
     * @return
     */
    Page queryPage(CuitCommodity entity, Pageable pageable);

    /**
     * 通过商品id修改最终价格
     * @param presentPrice
     * @param id
     * @return
     */
    CommonResult updateById(String presentPrice,Integer id,String buyUserId,String buyUserName);

    /**
     * 查看已经结束的商品
     * @param pageable
     * @return
     */
    Page<CuitCommodity> findByEndTimeBefore(Pageable pageable);
}
