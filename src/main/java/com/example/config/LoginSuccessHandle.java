package com.example.config;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


public class LoginSuccessHandle implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
		throws IOException, ServletException {
		
		Set<String> role = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
//		根據用戶權限為admin或其他,使用response.sendRedirect()跳轉到不同的頁面
		if(role.contains("admin")) {
			response.sendRedirect(basePath + "cms");
			return;
		}
		response.sendRedirect(basePath);
		
	}

}
