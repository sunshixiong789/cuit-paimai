package cn.edu.cuit.service;

import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.model.CuitTodaySpecial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/4/16 21:36
 */
public interface CuitTodaySpecialService {
    /**
     * 增加数据
     * @param entity
     * @return
     */
    CommonResult add(CuitTodaySpecial entity);
    /**
     * 删除数据
     * @param entity
     * @return
     */
    CommonResult delete(CuitTodaySpecial entity);
    /**
     * 修改数据
     * @param entity
     * @return
     */
    CommonResult update(CuitTodaySpecial entity);

    /**
     * 查询数据
     * @param entity
     * @return
     */
    List<CuitTodaySpecial> queryList(CuitTodaySpecial entity);

    /**
     * 分页查询
     * @return
     */
    Page queryPage(CuitTodaySpecial entity, Pageable pageable);
}
