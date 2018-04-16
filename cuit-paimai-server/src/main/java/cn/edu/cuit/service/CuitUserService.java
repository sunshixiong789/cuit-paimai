package cn.edu.cuit.service;

import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.model.CuitUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/4/16 20:52
 */
public interface CuitUserService {
    /**
     * 增加数据
     * @param entity
     * @return
     */
    CommonResult add(CuitUser entity);
    /**
     * 删除数据
     * @param entity
     * @return
     */
    CommonResult delete(CuitUser entity);
    /**
     * 修改数据
     * @param entity
     * @return
     */
    CommonResult update(CuitUser entity);

    /**
     * 查询数据
     * @param entity
     * @return
     */
    List<CuitUser> queryList(CuitUser entity);

    /**
     * 分页查询
     * @return
     */
    Page queryPage(CuitUser entity, Pageable pageable);
}
