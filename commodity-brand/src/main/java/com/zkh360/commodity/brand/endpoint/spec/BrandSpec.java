/**
 * 
 */
package com.zkh360.commodity.brand.endpoint.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.zkh360.commodity.brand.domain.Brand;
import com.zkh360.commodity.brand.service.dto.BrandCondition;

/**
 * @author zhailiang
 *
 */
public class BrandSpec implements Specification<Brand> {

	public BrandSpec(BrandCondition condition) {
		this.condition = condition;
	}

	private BrandCondition condition;

	@Override
	public Predicate toPredicate(Root<Brand> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Predicate predicate = null;
		
		if (!StringUtils.isEmpty(condition.getName())) {
			predicate = cb.equal(root.get("name"), condition.getName());
		}
		
		return predicate;
	}

}
