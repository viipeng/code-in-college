package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.po.UserInfo;

public class MyBatisTest {

	private SqlSessionFactory sessionFactory;
	private SqlSession sqlSession;
	
	//加载总配置文件 创建工程对象和session对象
	@Before
	public void init(){
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@After
	public void destroy(){
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void testAdd(){
		UserInfo userInfo = new UserInfo("vip", "12345", "yipeng");
		sqlSession.insert("addUserInfo", userInfo);
		System.out.println(userInfo);
	}
	@Test
	public void testGetUserById(){
		UserInfo userInfo = sqlSession.selectOne("getUserInfoById", 1);
		System.out.println(userInfo);
	}
	@Test
	public void testGetUsers(){
		List<UserInfo> users = sqlSession.selectList("getUsers");
		System.out.println(users);
	}
	@Test
	public void testUpdate(){
		UserInfo userInfo = sqlSession.selectOne("getUserInfoById", 2);
		userInfo.setuserName("djq");
		sqlSession.update("updateUserInfo", userInfo);
		System.out.println(userInfo);
	}
	@Test
	public void testDelete(){
		int userInfo = sqlSession.delete("deleteUser", 3);
		System.out.println(userInfo);
	}

}
