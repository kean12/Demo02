/**
 * 
 */
package com.zkh360.shopcart.endpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhailiang
 *
 */
@Data
@AllArgsConstructor
public class BrandCondition {
	
	private Long id;
	
	private String name;
	
	public BrandCondition() {}

}
