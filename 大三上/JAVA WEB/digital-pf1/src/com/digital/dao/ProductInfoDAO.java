package com.digital.dao;

import java.util.List;

import com.digital.entity.ProductInfo;

public interface ProductInfoDAO {

	public ProductInfo getProductInfoByPid(int 	pid);
	public List<ProductInfo> getAll();
}
