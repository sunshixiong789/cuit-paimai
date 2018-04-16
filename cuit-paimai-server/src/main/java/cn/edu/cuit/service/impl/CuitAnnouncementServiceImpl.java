package cn.edu.cuit.service.impl;

import cn.edu.cuit.cuitpaimairesource.common.CommonCRUD;
import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.dao.CuitFormDao;
import cn.edu.cuit.model.CuitAnnouncement;
import cn.edu.cuit.service.CuitAnnouncementService;
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
 * @date 2018/4/16 21:58
 */
@Slf4j
@Service(value = "cuitFormService")
public class CuitAnnouncementServiceImpl implements CuitAnnouncementService {
    @Autowired
    CuitFormDao formDao;

    @Override
    public CommonResult add(CuitAnnouncement entity) {
        return ServiceImplUtil.doCRUD(formDao,entity, CommonCRUD.JPAREPOSITORY_SAVE);
    }

    @Override
    public CommonResult delete(CuitAnnouncement entity) {
        return ServiceImplUtil.doCRUD(formDao,entity,CommonCRUD.JPAREPOSITORY_DELETE);
    }

    @Override
    public CommonResult update(CuitAnnouncement entity) {
        return ServiceImplUtil.doCRUD(formDao,entity,CommonCRUD.JPAREPOSITORY_UPDATE);
    }

    @Override
    public List<CuitAnnouncement> queryList(CuitAnnouncement entity) {
        Example example = Example.of(entity);
        return formDao.findAll(example);
    }

    @Override
    public Page queryPage(CuitAnnouncement entity, Pageable pageable) {
        Example example = Example.of(entity);
        return formDao.findAll(example,pageable);
    }
}
