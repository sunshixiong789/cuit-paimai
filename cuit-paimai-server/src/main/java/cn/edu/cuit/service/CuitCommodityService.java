package cn.edu.cuit.service;

import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.model.CuitCommodity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
}
