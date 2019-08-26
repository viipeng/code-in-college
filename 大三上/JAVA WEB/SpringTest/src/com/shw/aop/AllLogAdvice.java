package com.shw.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

public class AllLogAdvice {

	public void writeLog(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		String logText = "记录日志:"+" "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		logText+=" "+args[0].toString()+"正在浏览 "+args[1].toString()+"商品!";
		System.out.println(logText);
	}
}
