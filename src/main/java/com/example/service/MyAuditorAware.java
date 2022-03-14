package com.example.service;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.model.MyUserDetails;

@Component("auditorAware")
public class MyAuditorAware implements AuditorAware<String>{
	
	@Override
	public Optional<String> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication == null || !authentication.isAuthenticated()) {
			return null;
		}
//		return Optional.of(((MyUserDetails)authentication.getPrincipal()).getUsername());
		return Optional.of(((MyUserDetails)authentication.getPrincipal()).getUsername());
	}
	
}
