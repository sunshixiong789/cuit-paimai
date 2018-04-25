package cn.edu.cuit.service.impl;

import cn.edu.cuit.cuitpaimairesource.common.CommonCRUD;
import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.dao.CuitUserDao;
import cn.edu.cuit.model.CuitUser;
import cn.edu.cuit.service.CuitUserService;
import cn.edu.cuit.util.ServiceImplUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/4/16 21:25
 */
@Slf4j
@Service(value = "cuitUserService")
public class CuitUserServiceImpl implements CuitUserService {
    @Autowired
    CuitUserDao cuitUserDao;

    @Override
    public CommonResult add(CuitUser entity) {
        return ServiceImplUtil.doCRUD(cuitUserDao,entity, CommonCRUD.JPAREPOSITORY_SAVE);
    }

    @Override
    public CommonResult delete(CuitUser entity) {
        return ServiceImplUtil.doCRUD(cuitUserDao,entity,CommonCRUD.JPAREPOSITORY_DELETE);
    }

    @Override
    public CommonResult update(CuitUser entity) {
        return ServiceImplUtil.doCRUD(cuitUserDao,entity,CommonCRUD.JPAREPOSITORY_UPDATE);
    }

    @Override
    public List<CuitUser> queryList(CuitUser entity) {
        Example example = Example.of(entity);
        return cuitUserDao.findAll(example);
    }

    @Override
    public Page queryPage(CuitUser entity, Pageable pageable) {
        Example example = Example.of(entity);
        return cuitUserDao.findAll(example,pageable);
    }

    @Override
    public CuitUser findByUsername(String userName) {
        return cuitUserDao.findByUserName(userName);
    }
}
