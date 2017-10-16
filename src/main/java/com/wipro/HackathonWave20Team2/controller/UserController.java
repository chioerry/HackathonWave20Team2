package com.wipro.HackathonWave20Team2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wipro.HackathonWave20Team2.domain.UserBean;
import com.wipro.HackathonWave20Team2.service.UserService;

public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/user")
	public ResponseEntity<List<UserBean>> getAllUsers() {
		
		return ResponseEntity.ok( userService.getallusers());
		
	}
	@RequestMapping("/user/{id}")
	public ResponseEntity<String> getUser(@PathVariable int id) {
		userService.getUser(id);
		return ResponseEntity.ok("User Getting Successfully");
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public ResponseEntity<String> addUser(@RequestBody UserBean userBean) {
		
		userService.addUser(userBean);
		return ResponseEntity.ok("User saved successfully");
	}
	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	public ResponseEntity<String> updateUser(@RequestBody UserBean userBean, @PathVariable int id) {
		
		userService.updateUser(id,userBean);
		return ResponseEntity.ok("User Updated successfully");
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id) {
		
		 userService.deleteUser(id);
		 
		 return ResponseEntity.ok("User Deleted successfully");
	}
}
