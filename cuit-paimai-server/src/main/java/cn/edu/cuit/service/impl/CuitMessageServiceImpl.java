package cn.edu.cuit.service.impl;

import cn.edu.cuit.cuitpaimairesource.common.CommonCRUD;
import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.dao.CuitMessageDao;
import cn.edu.cuit.model.CuitMessage;
import cn.edu.cuit.service.CuitMessageService;
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
 * @date 2018/4/16 22:10
 */
@Slf4j
@Service(value = "cuitMessageService")
public class CuitMessageServiceImpl implements CuitMessageService {
    @Autowired
    CuitMessageDao messageDao;

    @Override
    public CommonResult add(CuitMessage entity) {
        return ServiceImplUtil.doCRUD(messageDao,entity, CommonCRUD.JPAREPOSITORY_SAVE);
    }

    @Override
    public CommonResult delete(CuitMessage entity) {
        return ServiceImplUtil.doCRUD(messageDao,entity,CommonCRUD.JPAREPOSITORY_DELETE);
    }

    @Override
    public CommonResult update(CuitMessage entity) {
        return ServiceImplUtil.doCRUD(messageDao,entity,CommonCRUD.JPAREPOSITORY_UPDATE);
    }

    @Override
    public List<CuitMessage> queryList(CuitMessage entity) {
        Example example = Example.of(entity);
        return messageDao.findAll(example);
    }

    @Override
    public Page queryPage(CuitMessage entity, Pageable pageable) {
        Example example = Example.of(entity);
        return messageDao.findAll(example,pageable);
    }
}
