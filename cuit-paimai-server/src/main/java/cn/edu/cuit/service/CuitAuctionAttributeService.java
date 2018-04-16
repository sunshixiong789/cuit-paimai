package cn.edu.cuit.service;

import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.model.CuitAuctionAttribute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *
 * @author sunshixiong on 2018/01/30.
 */
public interface CuitAuctionAttributeService {

	/**
	 * 增加数据
	 * @param entity
	 * @return
     */
	CommonResult add(CuitAuctionAttribute entity);
	/**
	 * 删除数据
	 * @param entity
	 * @return
	 */
	CommonResult delete(CuitAuctionAttribute entity);
	/**
	 * 修改数据
	 * @param entity
	 * @return
     */
	CommonResult update(CuitAuctionAttribute entity);

	/**
	 * 查询数据
	 * @param entity
	 * @return
     */
	List<CuitAuctionAttribute> queryList(CuitAuctionAttribute entity);

	/**
     * 分页查询
     * @return
     */
    Page queryPage(CuitAuctionAttribute entity, Pageable pageable);
}