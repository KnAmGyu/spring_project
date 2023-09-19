package com.uilangage.memo.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uilangage.memo.user.Service.UserService;

@RestController
public class UserController {

		@Autowired
		private UserService userService;
		
		@PostMapping("/join")
		public Map<String, String> join(
				@RequestParam("loginId") String loginId
				, ){
			
		}
		
}
