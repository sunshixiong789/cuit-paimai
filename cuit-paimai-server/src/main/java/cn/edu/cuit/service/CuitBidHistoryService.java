package cn.edu.cuit.service;

import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.model.CuitBidHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/3/27 21:47
 */
public interface CuitBidHistoryService {
    /**
     * 增加数据
     * @param entity
     * @return
     */
    CommonResult add(CuitBidHistory entity);
    /**
     * 删除数据
     * @param entity
     * @return
     */
    CommonResult delete(CuitBidHistory entity);
    /**
     * 修改数据
     * @param entity
     * @return
     */
    CommonResult update(CuitBidHistory entity);

    /**
     * 查询数据
     * @param entity
     * @return
     */
    List<CuitBidHistory> queryList(CuitBidHistory entity);

    /**
     * 分页查询
     * @return
     */
    Page queryPage(CuitBidHistory entity, Pageable pageable);
}
