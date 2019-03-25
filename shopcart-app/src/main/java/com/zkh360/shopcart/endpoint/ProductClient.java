/**
 * 
 */
package com.zkh360.shopcart.endpoint;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zkh360.shopcart.endpoint.dto.ProductInfo;

/**
 * @author zhailiang
 *
 */
@FeignClient("commodity-service")
public interface ProductClient {

	@GetMapping("/products/{id}")
	ProductInfo getInfo(@PathVariable("id") Long id);
	
}
