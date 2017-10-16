package com.wipro.HackathonWave20Team2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.HackathonWave20Team2.domain.UserBean;
import com.wipro.HackathonWave20Team2.exception.UserAlreadyExistException;
import com.wipro.HackathonWave20Team2.service.UserService;
@RestController
@RequestMapping("/users")
//The Rest Controller Annotation takes care of mapping requests with methods
public class UserController {
	@Autowired
	// Adding the dependecies through Autowired annotation from Interface
	UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	// This Annotation takes care to map specific response to a method with fixed value attribute
	public ResponseEntity<List<UserBean>> getAllUsers() {
		
		return ResponseEntity.ok( userService.getAllUsers());
		// ResponseEntity returns List along with HTTP Status.
	}
	
	@RequestMapping(method=RequestMethod.GET,value="{id}")
	// This Annotation takes care to map specific response to a method with fixed value attribute
	public ResponseEntity<String> getUser(@PathVariable String id) {
		userService.getUserById(id);
		return ResponseEntity.ok("User Getting Successfully");
		// ResponseEntity returns message along with HTTP Status.
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	// This Annotation takes care to map specific response to a method with fixed value attribute
	public ResponseEntity<String> addUser(@RequestBody UserBean userBean) throws UserAlreadyExistException{
		try {
			userService.addUser(userBean);
		}catch(UserAlreadyExistException ue){
			throw new UserAlreadyExistException("User Already Exists");
		}
		
		return ResponseEntity.ok("User saved successfully");
		// ResponseEntity returns message along with HTTP Status.
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="{id}")
	// This Annotation takes care to map specific response to a method with fixed value attribute
	public ResponseEntity<String> updateUser(@RequestBody UserBean userBean) {
		
		userService.updateUser(userBean);
		return ResponseEntity.ok("User Updated successfully");
		// ResponseEntity returns message along with HTTP Status.
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="{id}")
	// This Annotation takes care to map specific response to a method with fixed value attribute
	public ResponseEntity<String> deleteUser(@RequestBody UserBean userBean,@PathVariable String id) {
		
		 userService.deleteUser(userBean);
		 
		 return ResponseEntity.ok("User Deleted successfully");
		// ResponseEntity returns message along with HTTP Status.
	}
}
