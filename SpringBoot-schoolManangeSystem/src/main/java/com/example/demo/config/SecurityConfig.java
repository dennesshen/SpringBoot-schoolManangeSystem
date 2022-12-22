package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		 return new BCryptPasswordEncoder(); 
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 登入的相關路徑設定
		http.formLogin()
			.loginProcessingUrl("/perform_login")
			.loginPage("/aboutLogin/loginPage")
			.successForwardUrl("/")
			.failureForwardUrl("/view/test");
	
		//登入認證及授權設定
		http.authorizeHttpRequests()
			.antMatchers("/", "/view/**", "/aboutLogin/loginPage").permitAll()
			.antMatchers("/violation/", "/record/", "/classAndGrade/").hasRole("manager")
			.anyRequest().authenticated();
		
		//登出勝定
		http.logout()
		.deleteCookies("JSESSIONID")
		.logoutSuccessUrl("/")
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
			
	}

}
