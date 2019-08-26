package com.digital.interceptor;

import java.util.Map;

import com.digital.entity.UserInfo;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorizationInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		UserInfo userInfo=(UserInfo) session.get("CURRENT_USER");
		if(session==null)
		{
			return "login";
		}else{
			if(userInfo==null){
				return "login";
			}else{
				return invocation.invoke();
			}
		}
	}

	
}
