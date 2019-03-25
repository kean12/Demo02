/**
 * 
 */
package com.zkh360.order.endpoint;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author zhailiang
 *
 */
public interface OrderEventPublisher {

    String ORDER_EVENT_OUTPUT_CHANNEL = "bar";

    @Output(ORDER_EVENT_OUTPUT_CHANNEL)
    MessageChannel orderEventOutputChannel();

}
