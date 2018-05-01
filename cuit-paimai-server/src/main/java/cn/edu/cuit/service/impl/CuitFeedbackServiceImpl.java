package cn.edu.cuit.service.impl;

import cn.edu.cuit.common.CommonCRUD;
import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.dao.CuitFeedbackDao;
import cn.edu.cuit.model.CuitFeedback;
import cn.edu.cuit.service.CuitFeedbackService;
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
 * @date 2018/4/30 15:57
 */
@Slf4j
@Service(value = "cuitFeedbackService")
public class CuitFeedbackServiceImpl implements CuitFeedbackService {
    @Autowired
    CuitFeedbackDao feedbackDao;

    @Override
    public CommonResult add(CuitFeedback entity) {
        return ServiceImplUtil.doCRUD(feedbackDao,entity, CommonCRUD.JPAREPOSITORY_SAVE);
    }

    @Override
    public CommonResult delete(CuitFeedback entity) {
        return ServiceImplUtil.doCRUD(feedbackDao,entity,CommonCRUD.JPAREPOSITORY_DELETE);
    }

    @Override
    public CommonResult update(CuitFeedback entity) {
        return ServiceImplUtil.doCRUD(feedbackDao,entity,CommonCRUD.JPAREPOSITORY_UPDATE);
    }

    /**
     * 注视中表示创建一个匹配器，让字段名以属性值结束
     * @param entity
     * @return
     */
    @Override
    public List<CuitFeedback> queryList(CuitFeedback entity) {
        Example example = Example.of(entity);
        /*ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withMatcher("password",new ExampleMatcher.GenericPropertyMatcher().endsWith());*/
        return feedbackDao.findAll(example);
    }

    @Override
    public Page queryPage(CuitFeedback entity, Pageable pageable) {
        Example example = Example.of(entity);
        return feedbackDao.findAll(example,pageable);
    }
}
