/**
 * 
 */
package com.zkh360.shopcart.endpoint.dto;

import java.util.List;

import lombok.Data;

/**
 * @author zhailiang
 *
 */
@Data
public class PageData<T> {
	
	private List<T> content;
	
	private long totalElements;
	
	private boolean last;
	
	private int totalPages;
	
	private int size;
	
	private int number;
	
	private boolean first;
	
	private int numberOfElements;

}
