package cn.edu.cuit.service;

import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.model.CuitBid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/4/25 22:34
 */
public interface CuitBidService {
    /**
     * 增加数据
     * @param entity
     * @return
     */
    CommonResult add(CuitBid entity);
    /**
     * 删除数据
     * @param entity
     * @return
     */
    CommonResult delete(CuitBid entity);
    /**
     * 修改数据
     * @param entity
     * @return
     */
    CommonResult update(CuitBid entity);

    /**
     * 查询数据
     * @param entity
     * @return
     */
    List<CuitBid> queryList(CuitBid entity);

    /**
     * 分页查询
     * @return
     */
    Page queryPage(CuitBid entity, Pageable pageable);
}
