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
	
	//��ִ��һ����Է���֮ǰִ�и÷���
	@Before
	public void init(){
		//���� sessionFactory  hibernate.cfg.xml
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();//����һ��session
		transaction = session.beginTransaction();//����һ������
	}
	//ִ��һ����Դ���֮��Ĵ���
	@After
	public void destroy(){
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testAdd(){//���
		UserInfo userInfo = new UserInfo("vip","12345","yipeng");
		session.save(userInfo);
	}
	@Test
	public void testGetOne(){//��ѯ
		UserInfo userInfo = session.get(UserInfo.class,1);
		System.out.println(userInfo);
	}
	@Test
	public void testLoad(){//��ѯ
		UserInfo userInfo = session.load(UserInfo.class,2);
		System.out.println(userInfo);
	}
	
	@Test
	public void testUpdate(){//�޸�
		UserInfo userInfo = session.get(UserInfo.class,3);
		userInfo.setuserName("djq");
		userInfo.setPassword("12345");
		session.update(userInfo);
		System.out.println(userInfo);
	}
	@Test
	public void testDelete(){//ɾ��
		UserInfo userInfo = session.get(UserInfo.class,4);
		session.delete(userInfo);
		System.out.println(userInfo);
	}
}
