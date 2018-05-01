package cn.edu.cuit.service;

import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.model.CuitAnnouncement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/4/16 21:33
 */
public interface CuitAnnouncementService {
    /**
     * 增加数据
     *
     * @param entity
     * @return
     */
    CommonResult add(CuitAnnouncement entity);

    /**
     * 删除数据
     *
     * @param entity
     * @return
     */
    CommonResult delete(CuitAnnouncement entity);

    /**
     * 修改数据
     *
     * @param entity
     * @return
     */
    CommonResult update(CuitAnnouncement entity);

    /**
     * 查询数据
     *
     * @param entity
     * @return
     */
    List<CuitAnnouncement> queryList(CuitAnnouncement entity);

    /**
     * 分页查询
     *
     * @return
     */
    Page queryPage(CuitAnnouncement entity, Pageable pageable);
}
