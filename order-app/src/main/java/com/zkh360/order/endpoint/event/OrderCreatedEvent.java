/**
 * 
 */
package com.zkh360.order.endpoint.event;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zhailiang
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class OrderCreatedEvent extends OrderEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date createdTime;
	
}
