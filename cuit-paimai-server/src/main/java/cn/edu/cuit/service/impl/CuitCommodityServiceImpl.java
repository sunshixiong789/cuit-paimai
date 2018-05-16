package cn.edu.cuit.service.impl;

import cn.edu.cuit.common.CommonCRUD;
import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.dao.CuitCommodityDao;
import cn.edu.cuit.model.CuitCommodity;
import cn.edu.cuit.service.CuitCommodityService;
import cn.edu.cuit.util.ServiceImplUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/3/22 16:25
 */
@Service(value = "cuitCommodityService")
public class CuitCommodityServiceImpl implements CuitCommodityService {

    @Autowired
    CuitCommodityDao commodityDao;

    @Override
    public CommonResult add(CuitCommodity entity) {
        return ServiceImplUtil.doCRUD(commodityDao,entity, CommonCRUD.JPAREPOSITORY_SAVE);
    }

    @Override
    public CommonResult delete(CuitCommodity entity) {
        return ServiceImplUtil.doCRUD(commodityDao,entity,CommonCRUD.JPAREPOSITORY_DELETE);
    }

    @Override
    public CommonResult update(CuitCommodity entity) {
        return ServiceImplUtil.doCRUD(commodityDao,entity,CommonCRUD.JPAREPOSITORY_UPDATE);
    }

    @Override
    public List<CuitCommodity> queryList(CuitCommodity entity) {
        Example example = Example.of(entity);
        return commodityDao.findAll(example);
    }

    @Override
    public Page queryPage(CuitCommodity entity, Pageable pageable) {
        Example example = Example.of(entity);
        return commodityDao.findAll(example,pageable);
    }

    @Override
    @Transactional
    public CommonResult updateById(String presentPrice, Integer id,String buyUserId,String buyUserName) {
        CommonResult commonResult = new CommonResult();
        try {
            commodityDao.updateById(presentPrice,id,buyUserId,buyUserName);
            commonResult.setCode(200);
            commonResult.setMessage("修改价格成功");
        }catch (Exception e){
            commonResult.setCode(500);
            commonResult.setMessage("修改价格失败");
        }
        return commonResult;
    }

    @Override
    public Page<CuitCommodity> findByEndTimeBefore(Pageable pageable) {
        return commodityDao.findByEndTimeBefore(new Timestamp(System.currentTimeMillis()),pageable);
    }
}
