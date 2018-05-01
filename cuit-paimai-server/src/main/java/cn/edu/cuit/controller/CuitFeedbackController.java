package cn.edu.cuit.controller;

import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.model.CuitFeedback;
import cn.edu.cuit.service.CuitFeedbackService;
import cn.edu.cuit.validator.BindingResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/4/30 16:01
 */
@Slf4j
@RestController
@RequestMapping("cuitFeedback")
public class CuitFeedbackController {
    @Autowired
    private CuitFeedbackService feedbackService;

    /**
     * 增加一条数据
     * @param entity
     * @return
     */
    @PostMapping
    public CommonResult add(@Valid @RequestBody CuitFeedback entity, BindingResult results) {
        BindingResultUtil.JudegResult(results);
        return feedbackService.add(entity);
    }

    /**
     * 删除一条数据{使用正则表达式来控制id范围}
     * @param entity
     * @return
     */
    @DeleteMapping
    public CommonResult delete(@RequestBody CuitFeedback entity) {
        return feedbackService.delete(entity);
    }
    /**
     * 修改数据
     * @param entity
     * @return
     */
    @PutMapping
    public CommonResult update(@Valid @RequestBody CuitFeedback entity,BindingResult results){
        BindingResultUtil.JudegResult(results);
        return feedbackService.update(entity);
    }

    /**
     * 查询数据并且分页｛
     * 前台这样传参数：?size=2&page=1&sort=id,desc
     * ｝
     * @param entity
     * @param pageable
     * @return
     */
    @GetMapping
    public Page<CuitFeedback> query(CuitFeedback entity
            , @PageableDefault(size = 20,sort = "id"
            ,direction = Sort.Direction.ASC)Pageable pageable) {
        return feedbackService.queryPage(entity,pageable);
    }

    /**
     * 查询数据的列表
     * @param entity
     * @return
     */
    @GetMapping(value = "/list")
    public List<CuitFeedback> queryById(CuitFeedback entity) {
        return feedbackService.queryList(entity);
    }
}
