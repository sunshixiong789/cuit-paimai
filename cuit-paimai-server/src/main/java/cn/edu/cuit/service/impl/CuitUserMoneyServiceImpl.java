package cn.edu.cuit.service.impl;

import cn.edu.cuit.cuitpaimairesource.common.CommonCRUD;
import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.dao.CuitUserMoneyDao;
import cn.edu.cuit.model.CuitUserMoney;
import cn.edu.cuit.service.CuitUserMoneyService;
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
 * @date 2018/4/16 22:14
 */
@Slf4j
@Service(value = "cuitUserMoneyService")
public class CuitUserMoneyServiceImpl implements CuitUserMoneyService {
    @Autowired
    CuitUserMoneyDao userMoneyDao;

    @Override
    public CommonResult add(CuitUserMoney entity) {
        return ServiceImplUtil.doCRUD(userMoneyDao,entity, CommonCRUD.JPAREPOSITORY_SAVE);
    }

    @Override
    public CommonResult delete(CuitUserMoney entity) {
        return ServiceImplUtil.doCRUD(userMoneyDao,entity,CommonCRUD.JPAREPOSITORY_DELETE);
    }

    @Override
    public CommonResult update(CuitUserMoney entity) {
        return ServiceImplUtil.doCRUD(userMoneyDao,entity,CommonCRUD.JPAREPOSITORY_UPDATE);
    }

    @Override
    public List<CuitUserMoney> queryList(CuitUserMoney entity) {
        Example example = Example.of(entity);
        return userMoneyDao.findAll(example);
    }

    @Override
    public Page queryPage(CuitUserMoney entity, Pageable pageable) {
        Example example = Example.of(entity);
        return userMoneyDao.findAll(example,pageable);
    }

    @Override
    public CuitUserMoney findByUserId(String userId) {
        return userMoneyDao.findByUserId(userId);
    }
}
