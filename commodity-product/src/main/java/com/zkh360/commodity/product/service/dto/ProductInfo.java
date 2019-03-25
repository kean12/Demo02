/**
 * 
 */
package com.zkh360.commodity.product.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 商品信息
 * 
 * @author zhailiang
 *
 */
@Data
public class ProductInfo {
	
	/**
	 * id
	 */
	@ApiModelProperty("id")
	private Long id;
	/**
	 * 名称
	 */
	@ApiModelProperty("名称")
	private String name;
	/**
	 * 类目
	 */
	@ApiModelProperty("类目")
	private String catalog;
	/**
	 * 品牌
	 */
	@ApiModelProperty("品牌")
	private String brand;
	
	private ProductBasicInfo basicInfo;
	
	private ProductPriceInfo priceInfo;

}
