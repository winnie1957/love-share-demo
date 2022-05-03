package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.service.MyUserDetailsService;

@Configuration //表示這是一個設定spring用的class
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private UserDetailsService userDetailsService;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authPrvider = new DaoAuthenticationProvider();
		authPrvider.setUserDetailsService(userDetailsService());
		authPrvider.setPasswordEncoder(pwdEncoder());
		return authPrvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
//		auth.userDetailsService(userDetailsService).passwordEncoder(pwdEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/cms**").hasAnyAuthority("admin", "superadmin")
			.antMatchers("/wish/create", "/user**", "/{wId}/give").hasAnyAuthority("user", "admin", "superadmin")
//			.antMatchers("/wish/create", "/user**").hasAuthority("user")
//			.antMatchers("/wish/create", "/cms**", "/user**").authenticated()
			.anyRequest().permitAll()
			.and()
			.formLogin()
				.loginPage("/signin")
				.usernameParameter("uUsername")
				.passwordParameter("uPassword")
				//successHandler為關鍵,建立class(LoginSuccessHandle)處理登入後根據不同權限導向不同的頁面的方法
				.defaultSuccessUrl("/").successHandler(new LoginSuccessHandle()) 
				.permitAll()
			.and()
			.logout().logoutSuccessUrl("/signout").permitAll();
	}
	
	
	
}
