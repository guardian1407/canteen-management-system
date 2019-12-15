package com.iacsd.canteenmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.canteenmanagement.pojos.User;
import com.iacsd.canteenmanagement.response.UserResponse;
import com.iacsd.canteenmanagement.services.UserService;

@RestController
@RequestMapping("/canteenmanagement/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<UserResponse> getUserById(@PathVariable Integer id) {
		User user = userService.getUserById(id);
		return user != null ? new ResponseEntity<UserResponse>(new UserResponse("", user), HttpStatus.OK) 
							: new ResponseEntity<UserResponse>(new UserResponse("User with id : " + id + " not found."), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getalluser", produces = "application/json")
	public ResponseEntity<UserResponse> getAllUsers() {
		List<User> userList = userService.getAllUsers();
		return !userList.isEmpty() ? new ResponseEntity<UserResponse>(new UserResponse("", userList), HttpStatus.OK) 
									: new ResponseEntity<UserResponse>(new UserResponse("No users found."), HttpStatus.OK);
	}
	
	@PostMapping(value = "/saveuser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserResponse> saveUser(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<UserResponse>(new UserResponse("User saved successfully with id : " + savedUser.getId() + ".", savedUser), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/updateuser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserResponse> updateUser(@RequestBody User user) {
		Integer id = user.getId();
		User updatedUser = null;
		
		if(id != null && userService.getUserById(id) != null) 
			updatedUser = userService.updateUser(user);
		
		return updatedUser != null ? new ResponseEntity<UserResponse>(new UserResponse("User with id : " + id + " updated successfully.", updatedUser), HttpStatus.CREATED)
				: new ResponseEntity<UserResponse>(new UserResponse("Could not update the user.Either user id is invalid or user is not present in the system."), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteuser/{id}", produces = "application/json")
	public ResponseEntity<UserResponse> deleteUser(@PathVariable Integer id) {
		User deletedUser = null;
		
		if(userService.getUserById(id) != null) 
			deletedUser = userService.deleteUser(id);
		
		return deletedUser != null ? new ResponseEntity<UserResponse>(new UserResponse("User with id : " + id + " deleted successfully.", deletedUser), HttpStatus.OK) 
									: new ResponseEntity<UserResponse>(new UserResponse("User with id : " + id + " is not present in the system."), HttpStatus.OK);
	}
}







