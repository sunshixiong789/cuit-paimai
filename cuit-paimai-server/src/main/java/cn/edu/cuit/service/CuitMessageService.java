package cn.edu.cuit.service;

import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.model.CuitMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/4/16 21:35
 */
public interface CuitMessageService {
    /**
     * 增加数据
     * @param entity
     * @return
     */
    CommonResult add(CuitMessage entity);
    /**
     * 删除数据
     * @param entity
     * @return
     */
    CommonResult delete(CuitMessage entity);
    /**
     * 修改数据
     * @param entity
     * @return
     */
    CommonResult update(CuitMessage entity);

    /**
     * 查询数据
     * @param entity
     * @return
     */
    List<CuitMessage> queryList(CuitMessage entity);

    /**
     * 分页查询
     * @return
     */
    Page queryPage(CuitMessage entity, Pageable pageable);
}
