package cn.edu.cuit.service.impl;

import cn.edu.cuit.cuitpaimairesource.common.CommonCRUD;
import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.dao.CuitBidHistoryDao;
import cn.edu.cuit.model.CuitBidHistory;
import cn.edu.cuit.service.CuitBidHistoryService;
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
 * @date 2018/3/27 21:48
 */
@Slf4j
@Service(value = "cuitBidHistoryService")
public class CuitBidHistoryServiceImpl implements CuitBidHistoryService {
    @Autowired
    CuitBidHistoryDao bidHistoryDao;

    @Override
    public CommonResult add(CuitBidHistory entity) {
        return ServiceImplUtil.doCRUD(bidHistoryDao,entity, CommonCRUD.JPAREPOSITORY_SAVE);
    }

    @Override
    public CommonResult delete(CuitBidHistory entity) {
        return ServiceImplUtil.doCRUD(bidHistoryDao,entity,CommonCRUD.JPAREPOSITORY_DELETE);
    }

    @Override
    public CommonResult update(CuitBidHistory entity) {
        return ServiceImplUtil.doCRUD(bidHistoryDao,entity,CommonCRUD.JPAREPOSITORY_UPDATE);
    }

    @Override
    public List<CuitBidHistory> queryList(CuitBidHistory entity) {
        Example example = Example.of(entity);
        return bidHistoryDao.findAll(example);
    }

    @Override
    public Page queryPage(CuitBidHistory entity, Pageable pageable) {
        Example example = Example.of(entity);
        return bidHistoryDao.findAll(example,pageable);
    }
}
