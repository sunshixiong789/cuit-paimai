package cn.edu.cuit.service.impl;

import cn.edu.cuit.common.CommonCRUD;
import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.dao.CuitCommodityHistoryDao;
import cn.edu.cuit.model.CuitCommodityHistory;
import cn.edu.cuit.service.CuitCommodityHistoryService;
import cn.edu.cuit.util.ServiceImplUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 拍卖历史记录
 * @author sunshixiong
 * @date 2018/5/14 15:14
 */
@Slf4j
@Service("cuitCommodityHistoryService")
public class CuitCommodityHistoryServiceImpl implements CuitCommodityHistoryService {

    @Autowired
    CuitCommodityHistoryDao commodityHistory;

    @Override
    public CommonResult add(CuitCommodityHistory entity) {
        return ServiceImplUtil.doCRUD(commodityHistory,entity, CommonCRUD.JPAREPOSITORY_SAVE);
    }

    @Override
    public CommonResult delete(CuitCommodityHistory entity) {
        return ServiceImplUtil.doCRUD(commodityHistory,entity,CommonCRUD.JPAREPOSITORY_DELETE);
    }

    @Override
    public CommonResult update(CuitCommodityHistory entity) {
        return ServiceImplUtil.doCRUD(commodityHistory,entity,CommonCRUD.JPAREPOSITORY_UPDATE);
    }

    @Override
    public List<CuitCommodityHistory> queryList(CuitCommodityHistory entity) {
        Example example = Example.of(entity);
        return commodityHistory.findAll(example);
    }

    @Override
    public Page queryPage(CuitCommodityHistory entity, Pageable pageable) {
        Example example = Example.of(entity);
        return commodityHistory.findAll(example,pageable);
    }
}
