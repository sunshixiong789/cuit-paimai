package cn.edu.cuit.service;

import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.model.CuitFeedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/4/30 15:56
 */
public interface CuitFeedbackService {

    /**
     * 增加数据
     * @param entity
     * @return
     */
    CommonResult add(CuitFeedback entity);
    /**
     * 删除数据
     * @param entity
     * @return
     */
    CommonResult delete(CuitFeedback entity);
    /**
     * 修改数据
     * @param entity
     * @return
     */
    CommonResult update(CuitFeedback entity);

    /**
     * 查询数据
     * @param entity
     * @return
     */
    List<CuitFeedback> queryList(CuitFeedback entity);

    /**
     * 分页查询
     * @return
     */
    Page queryPage(CuitFeedback entity, Pageable pageable);
}
