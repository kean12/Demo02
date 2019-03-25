/**
 * 
 */
package com.zkh360.commodity.product.endpoint;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zkh360.commodity.product.service.dto.ProductBasicInfo;
import com.zkh360.commodity.product.service.dto.ProductInfo;
import com.zkh360.commodity.product.service.dto.ProductPriceInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 商品服务
 * 
 * @author zhailiang
 *
 */
@Api(tags = "商品服务")
@RestController
@RequestMapping("/products")
public class ProductController {

	/**
	 * 根据id获取商品信息
	 * 
	 * @author zhailiang@zkh360.com 2018年6月1日
	 * @param id
	 *            商品id
	 * @return
	 */
	@ApiOperation("根据id获取商品信息")
	@GetMapping
	public List<ProductInfo> getInfo(List<Long> ids) {
		return ids.stream().map(id -> {
			ProductInfo info = new ProductInfo();
			info.setBasicInfo(getProductBasicInfo(id));
			info.setPriceInfo(getProductPriceInfo(id));
			return info;
		}).collect(toList());
	}

	private ProductPriceInfo getProductPriceInfo(Long id) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ProductPriceInfo();
	}

	private ProductBasicInfo getProductBasicInfo(Long id) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ProductBasicInfo();
	}

	/**
	 * 根据id获取商品信息
	 * 
	 * @author zhailiang@zkh360.com 2018年6月1日
	 * @param id
	 *            商品id
	 * @return
	 */
	@ApiOperation("根据id获取商品信息")
	@ApiImplicitParam(name = "id", value = "商品ID", required = true, dataType = "String", paramType = "path")
	@GetMapping("/{id}")
	public ProductInfo getInfo(@PathVariable Long id) {
		ProductInfo info = new ProductInfo();
		info.setId(id);
		info.setName("product" + id);
		info.setBrand("brand1");
		info.setCatalog("catalog1");
		return info;
	}

}
