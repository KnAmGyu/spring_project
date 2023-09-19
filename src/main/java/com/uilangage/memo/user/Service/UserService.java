package com.uilangage.memo.user.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uilangage.memo.user.Repository.UserRepository;
import com.uilangage.memo.user.domain.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	public User addUser() { 
		
	}
}
