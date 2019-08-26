package com.digital.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.digital.entity.ProductInfo;
import com.digital.entity.Type;
import com.digital.service.ProductInfoService;
import com.digital.service.TypeService;
import com.opensymphony.xwork2.ActionSupport;

public class ProductInfoAction extends ActionSupport implements RequestAware{

	private ProductInfo pi;
	private TypeService typeService;
	private ProductInfoService productInfoService;
	private Map<String, Object> request;
	
	public String list(){
		List<Type> typeList = typeService.getAll();
		if(typeList.size()>0){
			request.put("typeList", typeList);
		}
		List<ProductInfo> piList = productInfoService.getAll();
		if(piList.size()>0){
			request.put("piList", piList);
		}
		return "index";
	}
	
	public String show(){
		ProductInfo productInfo = productInfoService.getProductInfoByPid(pi.getId());
		request.put("detailProductInfo", productInfo);
		return "show";
	}
	
	public ProductInfo getPi() {
		return pi;
	}

	public void setPi(ProductInfo pi) {
		this.pi = pi;
	}

	@Override
	public void setRequest(Map<String, Object> req) {
		this.request = req;
	}
	public void setProductInfoService(ProductInfoService productInfoService) {
		this.productInfoService = productInfoService;
	}
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}
	
}
