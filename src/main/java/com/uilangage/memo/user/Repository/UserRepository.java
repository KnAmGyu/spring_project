package com.uilangage.memo.user.Repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uilangage.memo.user.domain.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {
	
//	public User addUser(@Param("loginId") String loginId) {
//		 
//	}
	
}
