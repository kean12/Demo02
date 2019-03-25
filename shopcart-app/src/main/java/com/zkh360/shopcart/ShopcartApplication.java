/**
 * 
 */
package com.zkh360.shopcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.zkh360.shopcart.endpoint.InputChannels;

/**
 * @author zhailiang
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableBinding(InputChannels.class)
public class ShopcartApplication {

	/**
	 * 
	 * @author zhailiang@zkh360.com
	 * 2018年6月1日
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ShopcartApplication.class, args);
	}

}
