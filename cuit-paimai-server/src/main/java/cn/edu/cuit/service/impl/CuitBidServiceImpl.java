package cn.edu.cuit.service.impl;

import cn.edu.cuit.cuitpaimairesource.common.CommonCRUD;
import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.dao.CuitBidDao;
import cn.edu.cuit.model.CuitBid;
import cn.edu.cuit.model.CuitBid;
import cn.edu.cuit.service.CuitBidService;
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
 * @date 2018/4/25 22:40
 */
@Slf4j
@Service(value = "cuitBidService")
public class CuitBidServiceImpl implements CuitBidService {
    @Autowired
    CuitBidDao bidDao;

    @Override
    public CommonResult add(CuitBid entity) {
        return ServiceImplUtil.doCRUD(bidDao,entity, CommonCRUD.JPAREPOSITORY_SAVE);
    }

    @Override
    public CommonResult delete(CuitBid entity) {
        return ServiceImplUtil.doCRUD(bidDao,entity,CommonCRUD.JPAREPOSITORY_DELETE);
    }

    @Override
    public CommonResult update(CuitBid entity) {
        return ServiceImplUtil.doCRUD(bidDao,entity,CommonCRUD.JPAREPOSITORY_UPDATE);
    }

    @Override
    public List<CuitBid> queryList(CuitBid entity) {
        Example example = Example.of(entity);
        return bidDao.findAll(example);
    }

    @Override
    public Page queryPage(CuitBid entity, Pageable pageable) {
        Example example = Example.of(entity);
        return bidDao.findAll(example,pageable);
    }
}
