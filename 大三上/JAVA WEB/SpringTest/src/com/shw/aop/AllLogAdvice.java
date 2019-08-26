package com.shw.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

public class AllLogAdvice {

	public void writeLog(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		String logText = "��¼��־:"+" "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		logText+=" "+args[0].toString()+"������� "+args[1].toString()+"��Ʒ!";
		System.out.println(logText);
	}
}
