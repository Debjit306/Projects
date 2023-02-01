package com.medshop.service;

import com.medshop.entity.User;

public interface UserService {
	User login(String userName, String password);
}
