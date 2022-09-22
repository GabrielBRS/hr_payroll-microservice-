package com.gabrielsousa.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielsousa.hroauth.entities.User;
import com.gabrielsousa.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

	@Autowired
	private UserFeignClient userFeignClient;
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if(user==null) {
			logger.info("Email not found: "+email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found: "+email);
		return user;
	}
}
