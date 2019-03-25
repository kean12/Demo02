/**
 * 
 */
package com.zkh360.commodity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

import com.zkh360.commodity.product.endpoint.InputChannels;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhailiang
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableBinding(InputChannels.class)
public class CommodityApplication {

	/**
	 * 
	 * @author zhailiang@zkh360.com
	 * 2018年6月1日
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CommodityApplication.class, args);
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.zkh360"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("商品中心接口文档").description("RESTful 风格接口")
				.version("1.0")
				.build();
	}
}