package com.medshop.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.medshop.entity.User;
import com.medshop.model.UserDTO;


@Component
public class UserConverter {
	public User ConvertToEntity(UserDTO userDTO)
	{
		User user = new User();
		if (userDTO !=null) 
		{
			BeanUtils.copyProperties(userDTO,user);
		}
		return user;
	}
	public UserDTO ConvertToUserDTO(User user)
	{
		UserDTO userDTO = new UserDTO();
		if (user !=null) 
		{
			BeanUtils.copyProperties(user,userDTO);
		}
		return userDTO;
	}
}
