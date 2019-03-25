/**
 * 
 */
package com.zkh360.shopcart.endpoint.dto;

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
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 类目
	 */
	private String catalog;
	/**
	 * 品牌
	 */
	private String brand;

}
