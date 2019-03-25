/**
 * 
 */
package com.zkh360.commodity.brand.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zkh360.commodity.brand.service.dto.BrandCondition;
import com.zkh360.commodity.brand.service.dto.BrandInfo;

/**
 * @author zhailiang
 *
 */
public interface BrandService {
	
	/**
	 * 创建品牌
	 * @param BrandInfo
	 * @return
	 */
	BrandInfo create(BrandInfo brandInfo);
	/**
	 * 修改品牌
	 * @param BrandInfo
	 * @return
	 */
	BrandInfo update(BrandInfo brandInfo);
	/**
	 * 删除品牌
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 获取品牌详细信息
	 * @param id
	 * @return
	 */
	BrandInfo getInfo(Long id);
	/**
	 * 分页查询品牌
	 * @param condition
	 * @return
	 */
	Page<BrandInfo> query(BrandCondition condition, Pageable pageable);

}
