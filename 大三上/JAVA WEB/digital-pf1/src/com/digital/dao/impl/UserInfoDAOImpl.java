package com.digital.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.digital.dao.UserInfoDAO;
import com.digital.entity.UserInfo;

public class UserInfoDAOImpl implements UserInfoDAO {
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<UserInfo> search(UserInfo userInfo) {
		Session session=sessionFactory.getCurrentSession();
		List<UserInfo> users=null;
		Criteria c=session.createCriteria(UserInfo.class);
		Example example=Example.create(userInfo);
		c.add(example);
		users =c.list();
		return users;
	}

}
