package com.uilangage.memo.user.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uilangage.memo.user.Repository.UserRepository;
import com.uilangage.memo.user.domain.User;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(
			String loginId
			, String password
			, String name
			, String email) {
		
		User user = User.builder()
						.loginId(loginId)
						.password(password)
						.name(name)
						.email(email)
						.build();
		
		return userRepository.save(user);
		
	}

}