package com.medshop.serviceimpl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medshop.entity.User;
import com.medshop.repository.UserRepository;
import com.medshop.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger l = LoggerFactory.getLogger(User.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User login(String userName, String password) {
		User user = userRepository.findByUsernameAndPassword(userName, password);
		l.info("Admin "+user.toString()+" added at "+ new Date());
		return user;
	}

}
