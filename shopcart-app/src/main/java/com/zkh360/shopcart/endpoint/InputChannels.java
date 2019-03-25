/**
 * 
 */
package com.zkh360.shopcart.endpoint;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author zhailiang
 *
 */
public interface InputChannels {

	String ORDER_EVENT_INPUT_CHANNEL = "foo";

    @Input(ORDER_EVENT_INPUT_CHANNEL)
    SubscribableChannel getOrderInputChannel();
    
}
