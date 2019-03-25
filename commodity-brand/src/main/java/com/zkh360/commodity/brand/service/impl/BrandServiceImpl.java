/**
 * 
 */
package com.zkh360.commodity.brand.service.impl;

import static java.util.stream.Collectors.toList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkh360.commodity.brand.domain.Brand;
import com.zkh360.commodity.brand.endpoint.BrandRepository;
import com.zkh360.commodity.brand.endpoint.spec.BrandSpec;
import com.zkh360.commodity.brand.service.BrandService;
import com.zkh360.commodity.brand.service.dto.BrandCondition;
import com.zkh360.commodity.brand.service.dto.BrandInfo;

/**
 * @author zhailiang
 *
 */
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imooc.security.rbac.service.BrandService#create(com.imooc.security.rbac.
	 * dto.BrandInfo)
	 */
	@Override
	public BrandInfo create(BrandInfo info) {
		Brand brand = new Brand();
		BeanUtils.copyProperties(info, brand);
		brandRepository.save(brand);
		info.setId(brand.getId());
		return info;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imooc.security.rbac.service.BrandService#update(com.imooc.security.rbac.
	 * dto.BrandInfo)
	 */
	@Override
	@Transactional
	public BrandInfo update(BrandInfo info) {
		Brand brand = brandRepository.findOne(info.getId());
		BeanUtils.copyProperties(info, brand);
		return info;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.imooc.security.rbac.service.BrandService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		brandRepository.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.imooc.security.rbac.service.BrandService#getInfo(java.lang.Long)
	 */
	@Override
	public BrandInfo getInfo(Long id) {
		return brandRepository.findOne(id).getInfo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imooc.security.rbac.service.BrandService#query(com.imooc.security.rbac.
	 * dto.BrandInfo, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<BrandInfo> query(BrandCondition condition, Pageable pageable) {
		Page<Brand> brands = brandRepository.findAll(new BrandSpec(condition), pageable);
		return new PageImpl<>(brands.getContent().stream().map(brand -> brand.getInfo()).collect(toList()), pageable,
				brands.getTotalElements());
	}

}
