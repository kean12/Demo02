/**
 * 
 */
package com.zkh360.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.zkh360.order.endpoint.OrderEventPublisher;

/**
 * @author zhailiang
 *
 */
@SpringBootApplication
@EnableBinding(OrderEventPublisher.class)
public class OrderApplication {

	/**
	 * 
	 * @author zhailiang@zkh360.com
	 * 2018年6月4日
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}
