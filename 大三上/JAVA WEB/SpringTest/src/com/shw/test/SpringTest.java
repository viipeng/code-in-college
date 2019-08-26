package com.shw.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shw.service.ProductInfoService;
import com.shw.service.UserInfoService;

public class SpringTest {

	public static void main(String[] args) {

		ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserInfoService us =  (UserInfoService)act.getBean("userInfoService");
		boolean falg = us.login("admin", "123456");
		if(falg){
			System.out.println("��¼�ɹ�");
		}else{
			System.out.println("��¼ʧ��");
		}
		ProductInfoService prod = (ProductInfoService)act.getBean("productInfoService");
		prod.browse("admin", "iphone");
	}

}
