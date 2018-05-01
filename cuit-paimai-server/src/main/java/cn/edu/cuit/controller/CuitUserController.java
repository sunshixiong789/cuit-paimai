package cn.edu.cuit.controller;

import cn.edu.cuit.common.CommonResult;
import cn.edu.cuit.model.CuitUser;
import cn.edu.cuit.service.CuitUserService;
import cn.edu.cuit.validator.BindingResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author sunshixiong
 * @date 2018/4/16 20:51
 */
@Slf4j
@RestController
@RequestMapping(value = "/cuitUser")
public class CuitUserController{

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CuitUserService userService;

    /**
     * 增加一条数据
     * @param entity
     * @return
     */
    @PostMapping
    public CommonResult add(@Valid @RequestBody CuitUser entity, BindingResult results) {
        BindingResultUtil.JudegResult(results);
        entity.setPassWord(passwordEncoder.encode(entity.getPassWord()));
        return userService.add(entity);
    }

    /**
     * 删除一条数据{使用正则表达式来控制id范围}
     * @param entity
     * @return
     */
    @DeleteMapping
    public CommonResult delete(@RequestBody CuitUser entity) {
        return userService.delete(entity);
    }
    /**
     * 修改数据
     * @param entity
     * @return
     */
    @PutMapping
    public CommonResult update(@Valid @RequestBody CuitUser entity,BindingResult results){
        BindingResultUtil.JudegResult(results);
        return userService.update(entity);
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
    public Page<CuitUser> query(CuitUser entity
            , @PageableDefault(size = 10,sort = "id"
            ,direction = Sort.Direction.ASC)Pageable pageable) {
        return userService.queryPage(entity,pageable);
    }

    /**
     * 查询数据的列表
     * @param entity
     * @return
     */
    @GetMapping(value = "/list")
    public List<CuitUser> queryById(CuitUser entity) {
        return userService.queryList(entity);
    }
}
