/**
 * 
 */
package com.zkh360.commodity.brand.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedDate;

import com.zkh360.commodity.brand.service.dto.BrandInfo;

import lombok.Data;

/**
 * @author zhailiang
 *
 */
@Entity
@Data
public class Brand {

	@Id
	@GeneratedValue
	private Long id;
	
	@CreatedDate
	private Date createdTime;
	
	private String name;

	@Transient
	public BrandInfo getInfo() {
		BrandInfo info = new BrandInfo();
		BeanUtils.copyProperties(this, info);
		return info;
	}
	
}
