package cn.edu.cuit.service;

import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.model.CuitCommodityHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/5/14 15:12
 */
public interface CuitCommodityHistoryService {

    /**
     * 增加数据
     *
     * @param entity
     * @return
     */
    CommonResult add(CuitCommodityHistory entity);

    /**
     * 删除数据
     *
     * @param entity
     * @return
     */
    CommonResult delete(CuitCommodityHistory entity);

    /**
     * 修改数据
     *
     * @param entity
     * @return
     */
    CommonResult update(CuitCommodityHistory entity);

    /**
     * 查询数据
     *
     * @param entity
     * @return
     */
    List<CuitCommodityHistory> queryList(CuitCommodityHistory entity);

    /**
     * 分页查询
     *
     * @return
     */
    Page queryPage(CuitCommodityHistory entity, Pageable pageable);
}
