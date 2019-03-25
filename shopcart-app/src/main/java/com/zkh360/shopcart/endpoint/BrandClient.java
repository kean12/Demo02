/**
 * 
 */
package com.zkh360.shopcart.endpoint;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.zkh360.shopcart.endpoint.dto.BrandInfo;
import com.zkh360.shopcart.endpoint.dto.PageData;

/**
 * @author zhailiang
 *
 */
@FeignClient("commodity-service")
public interface BrandClient {

	/**
	 * 创建品牌
	 * @param BrandInfo
	 * @return
	 */
	@PostMapping("/brands")
	BrandInfo create(@RequestBody BrandInfo brandInfo);
	/**
	 * 修改品牌
	 * @param BrandInfo
	 * @return
	 */
	@PutMapping("/brands/{id}")
	BrandInfo update(@PathVariable("id") Long id, @RequestBody BrandInfo brandInfo);
	/**
	 * 删除品牌
	 * @param id
	 */
	@DeleteMapping("/brands/{id}")
	void delete(@PathVariable("id") Long id);
	/**
	 * 获取品牌详细信息
	 * @param id
	 * @return
	 */
	@GetMapping("/brands/{id}")
	BrandInfo getInfo(@PathVariable("id") Long id);
	/**
	 * 分页查询品牌
	 * @param condition
	 * @return
	 */
	@GetMapping("/brands")
	PageData<BrandInfo> query(@RequestParam Map<String, Object> map);
	
}
