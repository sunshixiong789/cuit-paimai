package cn.edu.cuit.service;

import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.model.CuitPicture;
import cn.edu.cuit.model.CuitPicture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/3/20 15:51
 */
public interface CuitPictureService {

    /**
     * 增加数据
     * @param entity
     * @return
     */
    CommonResult add(CuitPicture entity);
    /**
     * 删除数据
     * @param entity
     * @return
     */
    CommonResult delete(CuitPicture entity);
    /**
     * 修改数据
     * @param entity
     * @return
     */
    CommonResult update(CuitPicture entity);

    /**
     * 查询数据
     * @param entity
     * @return
     */
    List<CuitPicture> queryList(CuitPicture entity);

    /**
     * 分页查询
     * @return
     */
    Page queryPage(CuitPicture entity, Pageable pageable);
    /**
     * 通过商品id查询
     * @param commodityId
     * @return
     */
    List<CuitPicture> queryByCommodityId(String commodityId, Pageable pageable);
}
