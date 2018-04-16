package cn.edu.cuit.service;

import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.model.CuitAdmin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *
 * @author sunshixiong on 2018/01/30.
 */
public interface CuitAdminService {

	/**
	 * 增加数据
	 * @param entity
	 * @return
     */
	CommonResult add(CuitAdmin entity);
	/**
	 * 删除数据
	 * @param entity
	 * @return
	 */
	CommonResult delete(CuitAdmin entity);
	/**
	 * 修改数据
	 * @param entity
	 * @return
     */
	CommonResult update(CuitAdmin entity);

	/**
	 * 根据model查询数据
	 * @param cuitAdmin,pageable
	 * @return
     */
	Page<CuitAdmin> queryPage(CuitAdmin cuitAdmin, Pageable pageable);

	/**
	 * 根据model查询
	 * @param cuitAdmin
	 * @return
	 */
    List<CuitAdmin> queryList(CuitAdmin cuitAdmin);

}