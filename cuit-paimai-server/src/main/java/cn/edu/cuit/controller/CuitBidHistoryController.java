package cn.edu.cuit.controller;

import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.dao.CuitPictureDao;
import cn.edu.cuit.model.CuitBidHistory;
import cn.edu.cuit.service.CuitBidHistoryService;
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
 * 商品拍卖历史
 * @author sunshixiong
 * @date 2018/3/27 21:44
 */
@RestController
@RequestMapping(value = "cuitBidHistory")
public class CuitBidHistoryController {

    @Autowired
    private CuitBidHistoryService bidHistoryService;

    /**
     * 增加一条数据
     * @param entity
     * @return
     */
    @PostMapping
    public CommonResult add(@Valid @RequestBody CuitBidHistory entity, BindingResult results) {
        BindingResultUtil.JudegResult(results);
        return bidHistoryService.add(entity);
    }

    /**
     * 删除一条数据{使用正则表达式来控制id范围}
     * @param entity
     * @return
     */
    @DeleteMapping
    public CommonResult delete(@RequestBody CuitBidHistory entity) {
        return bidHistoryService.delete(entity);
    }
    /**
     * 修改数据
     * @param entity
     * @return
     */
    @PutMapping
    public CommonResult update(@Valid @RequestBody CuitBidHistory entity,BindingResult results){
        BindingResultUtil.JudegResult(results);
        return bidHistoryService.update(entity);
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
    public Page<CuitBidHistory> query(CuitBidHistory entity
            , @PageableDefault(size = 20,sort = "id"
            ,direction = Sort.Direction.ASC)Pageable pageable) {
        return bidHistoryService.queryPage(entity,pageable);
    }

    /**
     * 查询数据的列表
     * @param entity
     * @return
     */
    @GetMapping(value = "/list")
    public List<CuitBidHistory> queryById(CuitBidHistory entity) {
        return bidHistoryService.queryList(entity);
    }
}
