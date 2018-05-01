package cn.edu.cuit.controller;

import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.model.CuitBid;
import cn.edu.cuit.service.CuitBidService;
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
 * @author sunshixiong
 * @date 2018/4/25 22:42
 */
@RestController
@RequestMapping(value = "cuitBid")
public class CuitBidController {
    @Autowired
    private CuitBidService bidService;

    /**
     * 增加一条数据
     * @param entity
     * @return
     */
    @PostMapping
    public CommonResult add(@Valid @RequestBody CuitBid entity, BindingResult results) {
        BindingResultUtil.JudegResult(results);
        return bidService.add(entity);
    }

    /**
     * 删除一条数据{使用正则表达式来控制id范围}
     * @param entity
     * @return
     */
    @DeleteMapping
    public CommonResult delete(@RequestBody CuitBid entity) {
        return bidService.delete(entity);
    }
    /**
     * 修改数据
     * @param entity
     * @return
     */
    @PutMapping
    public CommonResult update(@Valid @RequestBody CuitBid entity,BindingResult results){
        BindingResultUtil.JudegResult(results);
        return bidService.update(entity);
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
    public Page<CuitBid> query(CuitBid entity
            , @PageableDefault(size = 10,sort = "id"
            ,direction = Sort.Direction.ASC)Pageable pageable) {
        return bidService.queryPage(entity,pageable);
    }

    /**
     * 查询数据的列表
     * @param entity
     * @return
     */
    @GetMapping(value = "/list")
    public List<CuitBid> queryById(CuitBid entity) {
        return bidService.queryList(entity);
    }
}
