package com.digital.service.impl;

import java.util.List;

import com.digital.dao.ProductInfoDAO;
import com.digital.entity.ProductInfo;
import com.digital.service.ProductInfoService;

public class ProductInfoServiceImpl implements ProductInfoService {

	private ProductInfoDAO productInfoDAO;
	
	
	public void setProductInfoDAO(ProductInfoDAO productInfoDAO) {
		this.productInfoDAO = productInfoDAO;
	}

	@Override
	public List<ProductInfo> getAll() {
		return productInfoDAO.getAll();
	}

	@Override
	public ProductInfo getProductInfoByPid(int pid) {
		return productInfoDAO.getProductInfoByPid(pid);
	}

}
