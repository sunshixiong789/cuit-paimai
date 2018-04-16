package cn.edu.cuit.service.impl;

import cn.edu.cuit.cuitpaimairesource.common.CommonCRUD;
import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.dao.CuitAdminDao;
import cn.edu.cuit.model.CuitAdmin;
import cn.edu.cuit.service.CuitAdminService;
import cn.edu.cuit.util.ServiceImplUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunshixiong on 2018/01/30.
 */
@Slf4j
@Service("cuitAdminService")
public class CuitAdminServiceImpl  implements CuitAdminService {
	@Autowired
	private CuitAdminDao cuitAdminDao;

	@Override
	public CommonResult add(CuitAdmin entity) {
		return ServiceImplUtil.doCRUD(cuitAdminDao,entity, CommonCRUD.JPAREPOSITORY_SAVE);
	}

	@Override
	public CommonResult delete(CuitAdmin entity) {
		return ServiceImplUtil.doCRUD(cuitAdminDao,entity,CommonCRUD.JPAREPOSITORY_DELETE);
	}

	@Override
	public CommonResult update(CuitAdmin entity) {
        return ServiceImplUtil.doCRUD(cuitAdminDao,entity,CommonCRUD.JPAREPOSITORY_UPDATE);
	}

	@Override
	public Page<CuitAdmin> queryPage(CuitAdmin cuitAdmin,Pageable pageable) {
		//创建匹配器，即如何使用查询条件
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("passWord");//忽略passWord属性
		Example example = Example.of(cuitAdmin,matcher);
		log.info("执行查询方法");
		Page page = cuitAdminDao.findAll(example,pageable);
        return page;
	}

	@Override
	public List<CuitAdmin> queryList(CuitAdmin cuitAdmin) {
		Example example = Example.of(cuitAdmin);
		return cuitAdminDao.findAll(example);
	}
}