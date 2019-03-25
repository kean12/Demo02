/**
 * 
 */
package com.zkh360.shopcart.endpoint.dto;

import java.util.Date;

import lombok.Data;

/**
 * @author zhailiang
 *
 */
@Data
public class BrandInfo {
	
	private Long id;
	
	private Date createdTime;
	
	private String name;
	
	public BrandInfo() { }
	
	public BrandInfo(String name) {
		this.name = name;
	}

}
