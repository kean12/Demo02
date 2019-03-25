/**
 * 
 */
package com.zkh360.commodity.brand.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zkh360.commodity.brand.service.BrandService;
import com.zkh360.commodity.brand.service.dto.BrandCondition;
import com.zkh360.commodity.brand.service.dto.BrandInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author zhailiang
 *
 */
@Api(tags = "品牌管理")
@RestController
@RequestMapping("/brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;

	/**
	 * 创建品牌
	 * @param brandInfo
	 * @return
	 */
	@ApiOperation("创建品牌")
	@PostMapping
	public BrandInfo create(@RequestBody BrandInfo brandInfo) {
		return brandService.create(brandInfo);
	}
	
	/**
	 * 修改品牌信息
	 * @param brandInfo
	 * @return
	 */
	@ApiOperation("修改品牌")
	@PutMapping("/{id}")
	public BrandInfo update(@RequestBody BrandInfo brandInfo) {
		return brandService.update(brandInfo);
	}
	
	/**
	 * 删除品牌
	 * @param id
	 */
	@ApiOperation("删除品牌")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		brandService.delete(id);
	}

	/**
	 * 获取品牌详情
	 * @param id
	 * @return
	 */
	@ApiOperation("获取品牌信息")
	@GetMapping("/{id}")
	public BrandInfo getInfo(@PathVariable Long id) {
		return brandService.getInfo(id);
	}

	/**
	 * 分页查询品牌
	 * @param brandInfo
	 * @param pageable
	 * @return
	 */
	@ApiOperation("分页查询品牌")
	@GetMapping
	public Page<BrandInfo> query(BrandCondition condition, Pageable pageable) {
		return brandService.query(condition, pageable);
	}
	
}
