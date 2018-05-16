package cn.edu.cuit.controller;

import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.model.CuitCommodityHistory;
import cn.edu.cuit.service.CuitCommodityHistoryService;
import cn.edu.cuit.validator.BindingResultUtil;
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
 * 拍卖历史
 * @author sunshixiong
 * @date 2018/5/14 17:26
 */
@RestController
@RequestMapping("cuitCommodityHistory")
public class CuitCommodityHistoryController {
    @Autowired
    private CuitCommodityHistoryService historyService;

    /**
     * 增加一条数据
     * @param entity
     * @return
     */
    @PostMapping
    public CommonResult add(@Valid @RequestBody CuitCommodityHistory entity, BindingResult results) {
        BindingResultUtil.JudegResult(results);
        return historyService.add(entity);
    }

    /**
     * 删除一条数据{使用正则表达式来控制id范围}
     * @param entity
     * @return
     */
    @DeleteMapping
    public CommonResult delete(@RequestBody CuitCommodityHistory entity) {
        return historyService.delete(entity);
    }
    /**
     * 修改数据
     * @param entity
     * @return
     */
    @PutMapping
    public CommonResult update(@Valid @RequestBody CuitCommodityHistory entity,BindingResult results){
        BindingResultUtil.JudegResult(results);
        return historyService.update(entity);
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
    public Page<CuitCommodityHistory> query(CuitCommodityHistory entity
            , @PageableDefault(size = 20,sort = "id"
            ,direction = Sort.Direction.ASC)Pageable pageable) {
        return historyService.queryPage(entity,pageable);
    }

    /**
     * 查询数据的列表
     * @param entity
     * @return
     */
    @GetMapping(value = "/list")
    public List<CuitCommodityHistory> queryById(CuitCommodityHistory entity) {
        return historyService.queryList(entity);
    }
}
