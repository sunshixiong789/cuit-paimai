package cn.edu.cuit.controller;

import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.model.CuitAnnouncement;
import cn.edu.cuit.service.CuitAnnouncementService;
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
 * @date 2018/4/16 22:32
 */
@Slf4j
@RestController
@RequestMapping(value = "/cuitForm")
public class CuitAnnouncementController {
    @Autowired
    private CuitAnnouncementService announcementService;

    /**
     * 增加一条数据
     * @param entity
     * @return
     */
    @PostMapping
    public CommonResult add(@Valid @RequestBody CuitAnnouncement entity, BindingResult results) {
        BindingResultUtil.JudegResult(results);
        return announcementService.add(entity);
    }

    /**
     * 删除一条数据{使用正则表达式来控制id范围}
     * @param entity
     * @return
     */
    @DeleteMapping
    public CommonResult delete(@RequestBody CuitAnnouncement entity) {
        return announcementService.delete(entity);
    }
    /**
     * 修改数据
     * @param entity
     * @return
     */
    @PutMapping
    public CommonResult update(@Valid @RequestBody CuitAnnouncement entity, BindingResult results){
        BindingResultUtil.JudegResult(results);
        return announcementService.update(entity);
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
    public Page<CuitAnnouncement> query(CuitAnnouncement entity
            , @PageableDefault(size = 20,sort = "id"
            ,direction = Sort.Direction.ASC)Pageable pageable) {
        return announcementService.queryPage(entity,pageable);
    }

    /**
     * 查询数据的列表
     * @param entity
     * @return
     */
    @GetMapping(value = "/list")
    public List<CuitAnnouncement> queryById(CuitAnnouncement entity) {
        return announcementService.queryList(entity);
    }
}
