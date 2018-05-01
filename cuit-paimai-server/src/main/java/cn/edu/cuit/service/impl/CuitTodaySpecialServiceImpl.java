package cn.edu.cuit.service.impl;

import cn.edu.cuit.common.CommonCRUD;
import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.dao.CuitTodaySpecialDao;
import cn.edu.cuit.model.CuitTodaySpecial;
import cn.edu.cuit.service.CuitTodaySpecialService;
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
 * @date 2018/4/16 22:13
 */
@Slf4j
@Service(value = "cuitTodaySpecialService")
public class CuitTodaySpecialServiceImpl implements CuitTodaySpecialService {
    @Autowired
    CuitTodaySpecialDao todaySpecialDao;

    @Override
    public CommonResult add(CuitTodaySpecial entity) {
        return ServiceImplUtil.doCRUD(todaySpecialDao,entity, CommonCRUD.JPAREPOSITORY_SAVE);
    }

    @Override
    public CommonResult delete(CuitTodaySpecial entity) {
        return ServiceImplUtil.doCRUD(todaySpecialDao,entity,CommonCRUD.JPAREPOSITORY_DELETE);
    }

    @Override
    public CommonResult update(CuitTodaySpecial entity) {
        return ServiceImplUtil.doCRUD(todaySpecialDao,entity,CommonCRUD.JPAREPOSITORY_UPDATE);
    }

    @Override
    public List<CuitTodaySpecial> queryList(CuitTodaySpecial entity) {
        Example example = Example.of(entity);
        return todaySpecialDao.findAll(example);
    }

    @Override
    public Page queryPage(CuitTodaySpecial entity, Pageable pageable) {
        Example example = Example.of(entity);
        return todaySpecialDao.findAll(example,pageable);
    }
}
