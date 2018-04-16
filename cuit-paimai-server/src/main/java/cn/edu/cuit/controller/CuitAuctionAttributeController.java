package cn.edu.cuit.controller;


import cn.edu.cuit.cuitpaimairesource.common.CommonResult;
import cn.edu.cuit.model.CuitAuctionAttribute;
import cn.edu.cuit.service.CuitAuctionAttributeService;
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
 * 拍卖属性
 * @author sunshixiong on 2018/01/30.
 */
@RestController
@RequestMapping("cuitAuctionAttribute")
public class CuitAuctionAttributeController {
	@Autowired
	private CuitAuctionAttributeService attributeService;

	/**
	 * 增加一条数据
	 * @param entity
	 * @return
	 */
	@PostMapping
	public CommonResult add(@Valid @RequestBody CuitAuctionAttribute entity, BindingResult results) {
		BindingResultUtil.JudegResult(results);
		return attributeService.add(entity);
	}

	/**
	 * 删除一条数据{使用正则表达式来控制id范围}
	 * @param entity
	 * @return
	 */
	@DeleteMapping
	public CommonResult delete(@RequestBody CuitAuctionAttribute entity) {
		return attributeService.delete(entity);
	}
	/**
	 * 修改数据
	 * @param entity
	 * @return
	 */
	@PutMapping
	public CommonResult update(@Valid @RequestBody CuitAuctionAttribute entity,BindingResult results){
		BindingResultUtil.JudegResult(results);
		return attributeService.update(entity);
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
	public Page<CuitAuctionAttribute> query(CuitAuctionAttribute entity
			, @PageableDefault(size = 20,sort = "id"
			,direction = Sort.Direction.ASC)Pageable pageable) {
		return attributeService.queryPage(entity,pageable);
	}

	/**
	 * 查询数据的列表
	 * @param entity
	 * @return
	 */
	@GetMapping(value = "/list")
	public List<CuitAuctionAttribute> queryById(CuitAuctionAttribute entity) {
		return attributeService.queryList(entity);
	}
}