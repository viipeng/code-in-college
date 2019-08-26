package com.digital.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digital.dao.UserInfoDao;
import com.digital.entity.UserInfo;
@Repository("userInfoDao")

public class UserInfoDAOImpl implements UserInfoDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserInfo> search(UserInfo userInfo) {
		List<UserInfo> uiList=null;
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(UserInfo.class);
		Example example = Example.create(userInfo);
		c.add(example);
		uiList = c.list();
		return uiList;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
