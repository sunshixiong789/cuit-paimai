package cn.edu.cuit.service.impl;

import cn.edu.cuit.common.CommonCRUD;
import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.dao.CuitPictureDao;
import cn.edu.cuit.model.CuitPicture;
import cn.edu.cuit.service.CuitPictureService;
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
 * @date 2018/3/20 15:56
 */
@Slf4j
@Service(value = "cuitPictureService")
public class CuitPictureServiceImpl implements CuitPictureService {

    @Autowired
    CuitPictureDao pictureDao;

    @Override
    public CommonResult add(CuitPicture entity) {
        return ServiceImplUtil.doCRUD(pictureDao,entity, CommonCRUD.JPAREPOSITORY_SAVE);
    }

    @Override
    public CommonResult delete(CuitPicture entity) {
        return ServiceImplUtil.doCRUD(pictureDao,entity,CommonCRUD.JPAREPOSITORY_DELETE);
    }

    @Override
    public CommonResult update(CuitPicture entity) {
        return ServiceImplUtil.doCRUD(pictureDao,entity,CommonCRUD.JPAREPOSITORY_UPDATE);
    }

    @Override
    public List<CuitPicture> queryList(CuitPicture entity) {
        Example example = Example.of(entity);
        return pictureDao.findAll(example);
    }

    @Override
    public Page queryPage(CuitPicture entity, Pageable pageable) {
        Example example = Example.of(entity);
        return pictureDao.findAll(example,pageable);
    }
    @Override
    public List<CuitPicture> queryByCommodityId(String commodityId, Pageable pageable) {
        return pictureDao.findByCuitCommodityId(commodityId,pageable);
    }
}
