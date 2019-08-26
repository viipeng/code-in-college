package com.digital.service;

import java.util.List;

import com.digital.entity.ProductInfo;

public interface ProductInfoService {

	public List<ProductInfo> getAll();
	public ProductInfo getProductInfoByPid(int pid);
}
