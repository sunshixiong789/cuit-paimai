package cn.edu.cuit.controller;

import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.model.CuitMessage;
import cn.edu.cuit.service.CuitMessageService;
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
 * @date 2018/4/16 22:38
 */
@Slf4j
@RestController
@RequestMapping(value = "/cuitMessage")
public class CuitMessageController {
    @Autowired
    private CuitMessageService messageService;

    /**
     * 增加一条数据
     * @param entity
     * @return
     */
    @PostMapping
    public CommonResult add(@Valid @RequestBody CuitMessage entity, BindingResult results) {
        BindingResultUtil.JudegResult(results);
        return messageService.add(entity);
    }

    /**
     * 删除一条数据{使用正则表达式来控制id范围}
     * @param entity
     * @return
     */
    @DeleteMapping
    public CommonResult delete(@RequestBody CuitMessage entity) {
        return messageService.delete(entity);
    }
    /**
     * 修改数据
     * @param entity
     * @return
     */
    @PutMapping
    public CommonResult update(@Valid @RequestBody CuitMessage entity,BindingResult results){
        BindingResultUtil.JudegResult(results);
        return messageService.update(entity);
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
    public Page<CuitMessage> query(CuitMessage entity
            , @PageableDefault(size = 20,sort = "id"
            ,direction = Sort.Direction.ASC)Pageable pageable) {
        return messageService.queryPage(entity,pageable);
    }

    /**
     * 查询数据的列表
     * @param entity
     * @return
     */
    @GetMapping(value = "/list")
    public List<CuitMessage> queryById(CuitMessage entity) {
        return messageService.queryList(entity);
    }
}
