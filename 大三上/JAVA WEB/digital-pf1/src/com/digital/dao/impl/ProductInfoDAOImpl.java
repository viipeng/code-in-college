package com.digital.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.digital.dao.ProductInfoDAO;
import com.digital.entity.ProductInfo;
import com.digital.entity.Type;

public class ProductInfoDAOImpl implements ProductInfoDAO {

    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	@Override
	public List<ProductInfo> getAll() {
		List<ProductInfo> piList = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(ProductInfo.class);
		piList = c.list();
		//System.out.println(piList);
		return piList;
	}



	@Override
	public ProductInfo getProductInfoByPid(int pid) {
		Session session = sessionFactory.getCurrentSession();
		ProductInfo productInfo = session.get(ProductInfo.class, pid);
		return productInfo;
	}

}
