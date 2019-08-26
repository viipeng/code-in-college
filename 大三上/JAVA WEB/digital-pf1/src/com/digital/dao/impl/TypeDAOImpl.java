package com.digital.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.digital.dao.TypeDAO;
import com.digital.entity.Type;

public class TypeDAOImpl implements TypeDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Type> getAll() {
		List<Type> typeList = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Type.class);
		typeList = c.list();
		return typeList;
	}

}
