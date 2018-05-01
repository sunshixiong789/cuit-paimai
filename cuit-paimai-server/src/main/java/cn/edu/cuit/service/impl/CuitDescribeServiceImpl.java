package cn.edu.cuit.service.impl;

import cn.edu.cuit.common.CommonCRUD;
import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.dao.CuitDescribeDao;
import cn.edu.cuit.model.CuitDescribe;
import cn.edu.cuit.service.CuitDescribeService;
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
 * @date 2018/4/16 21:55
 */
@Slf4j
@Service(value = "cuitDescribeService")
public class CuitDescribeServiceImpl implements CuitDescribeService {
    @Autowired
    CuitDescribeDao describeDao;

    @Override
    public CommonResult add(CuitDescribe entity) {
        return ServiceImplUtil.doCRUD(describeDao,entity, CommonCRUD.JPAREPOSITORY_SAVE);
    }

    @Override
    public CommonResult delete(CuitDescribe entity) {
        return ServiceImplUtil.doCRUD(describeDao,entity,CommonCRUD.JPAREPOSITORY_DELETE);
    }

    @Override
    public CommonResult update(CuitDescribe entity) {
        return ServiceImplUtil.doCRUD(describeDao,entity,CommonCRUD.JPAREPOSITORY_UPDATE);
    }

    @Override
    public List<CuitDescribe> queryList(CuitDescribe entity) {
        Example example = Example.of(entity);
        return describeDao.findAll(example);
    }

    @Override
    public Page queryPage(CuitDescribe entity, Pageable pageable) {
        Example example = Example.of(entity);
        return describeDao.findAll(example,pageable);
    }

    @Override
    public List<CuitDescribe> listByCommodityId(Integer id) {
        return describeDao.findByCuitCommodityId(id);
    }
}
