/**
 * 
 */
package com.zkh360.shopcart.endpoint;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhailiang
 *
 */
@Slf4j
@Component
public class ShopcartListener {

	@StreamListener("foo")
	public void onOrderMessage(Message<String> message) {
		log.info("message is :" + message);
	}

}
