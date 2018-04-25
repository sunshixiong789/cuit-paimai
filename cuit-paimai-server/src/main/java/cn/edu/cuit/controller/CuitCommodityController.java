package cn.edu.cuit.controller;

import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.dao.CuitCommodityDao;
import cn.edu.cuit.model.CuitCommodity;
import cn.edu.cuit.model.CuitCommodity;
import cn.edu.cuit.service.CuitCommodityService;
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
 * @date 2018/3/22 16:16
 */
@RestController
@RequestMapping(value = "/cuitCommodity")
public class CuitCommodityController {

    @Autowired
    private CuitCommodityService commodityService;

    /**
     * 增加一条数据
     * @param entity
     * @return
     */
    @PostMapping
    public CommonResult add(@Valid @RequestBody CuitCommodity entity, BindingResult results) {
        BindingResultUtil.JudegResult(results);
        return commodityService.add(entity);
    }

    /**
     * 删除一条数据{使用正则表达式来控制id范围}
     * @param entity
     * @return
     */
    @DeleteMapping
    public CommonResult delete(@RequestBody CuitCommodity entity) {
        return commodityService.delete(entity);
    }
    /**
     * 修改数据
     * @param entity
     * @return
     */
    @PutMapping
    public CommonResult update(@Valid @RequestBody CuitCommodity entity,BindingResult results){
        BindingResultUtil.JudegResult(results);
        return commodityService.update(entity);
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
    public Page<CuitCommodity> query(CuitCommodity entity
            , @PageableDefault(size = 10,sort = "id"
            ,direction = Sort.Direction.ASC)Pageable pageable) {
        return commodityService.queryPage(entity,pageable);
    }

    /**
     * 查询数据的列表
     * @param entity
     * @return
     */
    @GetMapping(value = "/list")
    public List<CuitCommodity> queryById(CuitCommodity entity) {
        return commodityService.queryList(entity);
    }
}
