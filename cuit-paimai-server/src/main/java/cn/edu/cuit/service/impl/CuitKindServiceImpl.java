package cn.edu.cuit.service.impl;

import cn.edu.cuit.common.CommonCRUD;
import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.dao.CuitKindDao;
import cn.edu.cuit.model.CuitKind;
import cn.edu.cuit.service.CuitKindService;
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
 * @date 2018/4/16 22:08
 */
@Slf4j
@Service(value = "cuitKindService")
public class CuitKindServiceImpl implements CuitKindService {
    @Autowired
    CuitKindDao kindDao;

    @Override
    public CommonResult add(CuitKind entity) {
        return ServiceImplUtil.doCRUD(kindDao,entity, CommonCRUD.JPAREPOSITORY_SAVE);
    }

    @Override
    public CommonResult delete(CuitKind entity) {
        return ServiceImplUtil.doCRUD(kindDao,entity,CommonCRUD.JPAREPOSITORY_DELETE);
    }

    @Override
    public CommonResult update(CuitKind entity) {
        return ServiceImplUtil.doCRUD(kindDao,entity,CommonCRUD.JPAREPOSITORY_UPDATE);
    }

    @Override
    public List<CuitKind> queryList(CuitKind entity) {
        Example example = Example.of(entity);
        return kindDao.findAll(example);
    }

    @Override
    public Page queryPage(CuitKind entity, Pageable pageable) {
        Example example = Example.of(entity);
        return kindDao.findAll(example,pageable);
    }
}
