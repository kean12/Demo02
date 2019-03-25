/**
 * 
 */
package com.zkh360.shopcart.endpoint;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zkh360.shopcart.endpoint.dto.BrandCondition;
import com.zkh360.shopcart.endpoint.dto.BrandInfo;
import com.zkh360.shopcart.endpoint.dto.ProductInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * 购物车服务
 * 
 * @author zhailiang
 *
 */
@Slf4j
@RestController
@RequestMapping("/shopcart/item")
public class ShopcartController {

//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private ProductClient productClient;
	
	@Autowired
	private BrandClient brandClient;

	/**
	 * 将商品加入购物车，创建购物车项
	 * 
	 * @author zhailiang@zkh360.com 2018年6月1日
	 * @param id
	 *            商品id
	 * @return
	 */
	@PostMapping
	public void create(Long productId) {

//		String url = "http://commodity-service/product/" + productId;
//		ProductInfo info = restTemplate.getForObject(url, ProductInfo.class);
		
		ProductInfo info = productClient.getInfo(productId);

		log.info(info.getName());
		
		
	}
	
	@GetMapping
	public void testFeign(String name) {

		BrandInfo brandInfo = new BrandInfo(name);
		Long id = brandClient.create(brandInfo).getId();

		brandInfo.setId(id);
		brandInfo.setName(name + "XXX");
		brandClient.update(id, brandInfo);

		brandClient.query(transBean2Map(new BrandCondition(1L, name + "XXX"),
						new PageRequest(0, 3, new Sort(Direction.DESC, "id"))))
				.getContent().stream().forEach(info -> System.out.println(info.getName()));

		brandClient.delete(id);
		
	}
	
	public static Map<String, Object> transBean2Map(Object obj, Pageable pageable) {

		pageable.getSort().toString();

		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				if (!key.equals("class")) {
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj);
					map.put(key, value);
				}

			}

			map.put("page", pageable.getPageNumber());
			map.put("size", pageable.getPageSize());
			map.put("sort", StringUtils.replace(pageable.getSort().toString(), ": ", ","));

		} catch (Exception e) {
			log.info("transBean2Map Error " + e);
		}

		return map;

	}

}
