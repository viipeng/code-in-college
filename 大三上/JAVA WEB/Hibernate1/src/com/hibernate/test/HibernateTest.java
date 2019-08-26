package com.hibernate.test;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.hibernate.entity.UserInfo;
import org.junit.*;

public class HibernateTest {
		
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	//在执行一般测试方法之前执行该方法
	@Before
	public void init(){
		//创建 sessionFactory  hibernate.cfg.xml
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();//创建一个session
		transaction = session.beginTransaction();//开启一个事务
	}
	//执行一般测试代码之后的代码
	@After
	public void destroy(){
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testAdd(){//添加
		UserInfo userInfo = new UserInfo("vip","12345","yipeng");
		session.save(userInfo);
	}
	@Test
	public void testGetOne(){//查询
		UserInfo userInfo = session.get(UserInfo.class,1);
		System.out.println(userInfo);
	}
	@Test
	public void testLoad(){//查询
		UserInfo userInfo = session.load(UserInfo.class,2);
		System.out.println(userInfo);
	}
	
	@Test
	public void testUpdate(){//修改
		UserInfo userInfo = session.get(UserInfo.class,3);
		userInfo.setuserName("djq");
		userInfo.setPassword("12345");
		session.update(userInfo);
		System.out.println(userInfo);
	}
	@Test
	public void testDelete(){//删除
		UserInfo userInfo = session.get(UserInfo.class,4);
		session.delete(userInfo);
		System.out.println(userInfo);
	}
}
