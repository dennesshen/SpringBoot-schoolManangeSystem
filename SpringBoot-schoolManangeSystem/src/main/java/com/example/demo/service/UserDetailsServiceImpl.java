package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserLogin;
import com.example.demo.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserLogin userLogin = userRepository.findByUsername(username);
		if (userLogin == null) {
			throw new UsernameNotFoundException("Not found");
		}
		
		String password = userLogin.getPassword();
		String authority = userLogin.getRole();
		
		
		return new User(username, 
						password, 
						AuthorityUtils.commaSeparatedStringToAuthorityList(authority));
	}
	
}
