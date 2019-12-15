package com.iacsd.canteenmanagement.response;

import java.util.List;

import com.iacsd.canteenmanagement.pojos.User;

public class UserResponse extends Response{
	
	private User user;
	private List<User> userList;
	
	public UserResponse(String message) {
		super(message);
	}

	public UserResponse(String message, User user) {
		super(message);
		this.user = user;
	}

	public UserResponse(String message, List<User> userList) {
		super(message);
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
