package cn.edu.cuit.service;

import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.model.CuitKind;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/4/16 21:35
 */
public interface CuitKindService {
    /**
     * 增加数据
     * @param entity
     * @return
     */
    CommonResult add(CuitKind entity);
    /**
     * 删除数据
     * @param entity
     * @return
     */
    CommonResult delete(CuitKind entity);
    /**
     * 修改数据
     * @param entity
     * @return
     */
    CommonResult update(CuitKind entity);

    /**
     * 查询数据
     * @param entity
     * @return
     */
    List<CuitKind> queryList(CuitKind entity);

    /**
     * 分页查询
     * @return
     */
    Page queryPage(CuitKind entity, Pageable pageable);
}
