package com.iacsd.canteenmanagement.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.canteenmanagement.pojos.User;
import com.iacsd.canteenmanagement.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User getUserById(Integer id) {
		User user = userRepo.findById(id).orElse(null);
		return user != null && !user.isIs_dropped() ? user : null;
	}

	public List<User> getAllUsers() {
		List<User> userList = (List<User>) userRepo.findAll();
		
		userList = userList.stream()
								.filter(user -> user.isIs_dropped() == false)
								.collect(Collectors.toList());
		
		return userList;
	}
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public User updateUser(User user){
		return saveUser(user);
	}
	
	public User deleteUser(Integer id) {
		User user = userRepo.findById(id).orElse(null);
		
		if(user != null) {
			user.setIs_dropped(true);
			user.setOrders(user.getOrders().stream()
											.map(order -> {
													order.setIs_dropped(true);
													return order;
												})
											.collect(Collectors.toList()));
			
			user = userRepo.save(user);
		}
		
		return user;
	}
}










