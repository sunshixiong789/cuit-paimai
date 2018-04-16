package cn.edu.cuit.controller;

import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.model.CuitPicture;
import cn.edu.cuit.model.CuitPicture;
import cn.edu.cuit.service.CuitPictureService;
import cn.edu.cuit.service.CuitPictureService;
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
 * 获取商品图片
 * @author sunshixiong
 * @date 2018/3/26 14:26
 */
@RestController
@RequestMapping("/cuitPicture")
public class CuitPictureController {

    @Autowired
    private CuitPictureService pictureService;

    /**
     * 增加一条数据
     * @param entity
     * @return
     */
    @PostMapping
    public CommonResult add(@Valid @RequestBody CuitPicture entity, BindingResult results) {
        BindingResultUtil.JudegResult(results);
        return pictureService.add(entity);
    }

    /**
     * 删除一条数据{使用正则表达式来控制id范围}
     * @param entity
     * @return
     */
    @DeleteMapping
    public CommonResult delete(@RequestBody CuitPicture entity) {
        return pictureService.delete(entity);
    }
    /**
     * 修改数据
     * @param entity
     * @return
     */
    @PutMapping
    public CommonResult update(@Valid @RequestBody CuitPicture entity,BindingResult results){
        BindingResultUtil.JudegResult(results);
        return pictureService.update(entity);
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
    public Page<CuitPicture> query(CuitPicture entity
            , @PageableDefault(size = 20,sort = "id"
            ,direction = Sort.Direction.ASC)Pageable pageable) {
        return pictureService.queryPage(entity,pageable);
    }

    /**
     * 查询数据的列表
     * @param entity
     * @return
     */
    @GetMapping(value = "/list")
    public List<CuitPicture> queryById(CuitPicture entity) {
        return pictureService.queryList(entity);
    }
 }
