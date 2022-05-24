package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		 return new BCryptPasswordEncoder(); 
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginProcessingUrl("/perform_login")
			.loginPage("/aboutLogin/loginPage")
			.successForwardUrl("/view/")
			.failureForwardUrl("/view/test");
	
		
		http.authorizeHttpRequests()
			.antMatchers("/violation/**", "/record/**", "/classAndGrade/**" ).authenticated()
			.anyRequest().permitAll();
//			.and()
//			.csrf().disable();
		
			
	}

}
