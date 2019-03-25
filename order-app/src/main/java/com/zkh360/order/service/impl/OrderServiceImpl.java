/**
 * 
 */
package com.zkh360.order.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.zkh360.order.endpoint.OrderEventPublisher;
import com.zkh360.order.endpoint.event.OrderCreatedEvent;
import com.zkh360.order.service.OrderService;

/**
 * @author zhailiang
 *
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderEventPublisher orderEventPublisher;

	@Override
	public void create() {
		//do create order
		
		OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();
		orderCreatedEvent.setId(1L);
		orderCreatedEvent.setProductIds(Lists.newArrayList(1L, 2L, 3L));
		orderCreatedEvent.setCreatedTime(new Date());
		
		orderEventPublisher.orderEventOutputChannel()
			.send(MessageBuilder.withPayload(orderCreatedEvent).build(), 1000);
		
//		throw new RuntimeException("test");
		
	}

}
