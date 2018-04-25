package cn.edu.cuit.service;

import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.model.CuitUserMoney;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/4/16 21:38
 */
public interface CuitUserMoneyService {
    /**
     * 增加数据
     * @param entity
     * @return
     */
    CommonResult add(CuitUserMoney entity);
    /**
     * 删除数据
     * @param entity
     * @return
     */
    CommonResult delete(CuitUserMoney entity);
    /**
     * 修改数据
     * @param entity
     * @return
     */
    CommonResult update(CuitUserMoney entity);

    /**
     * 查询数据
     * @param entity
     * @return
     */
    List<CuitUserMoney> queryList(CuitUserMoney entity);

    /**
     * 分页查询
     * @return
     */
    Page queryPage(CuitUserMoney entity, Pageable pageable);

    /**
     * 通过用户id查找金额
     * @param userId
     * @return
     */
    CuitUserMoney findByUserId(String userId);
}
