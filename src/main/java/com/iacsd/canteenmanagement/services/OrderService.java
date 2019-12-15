package com.iacsd.canteenmanagement.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.canteenmanagement.pojos.Cart;
import com.iacsd.canteenmanagement.pojos.Order;
import com.iacsd.canteenmanagement.pojos.User;
import com.iacsd.canteenmanagement.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private UserService userService;
	
	public Order getOrderById(Integer id) {
		Order order = orderRepo.findById(id).orElse(null);
		return order != null && !order.isIs_dropped() ? order : null;
	}

	public List<Order> getAllOrders() {
		List<Order> orderList = (List<Order>) orderRepo.findAll();
		
		orderList = orderList.stream()
							.filter(order -> order.isIs_dropped() == false)
							.collect(Collectors.toList());
		
		return orderList;
	}
	
	public Order saveOrder(Cart cart) throws ParseException {
		Integer userId = cart.getUserId();
		Order order = null;
		
		if(userService.getUserById(userId) != null) {
			User user = new User();
			user.setId(userId);
			String foodItems = cart.getSelectedItems().stream().map(item -> item.getQuantity() + " x " + item.getFoodName()).collect(Collectors.joining(","));
			Double amount = cart.getSelectedItems().stream().mapToDouble(item -> item.getAmount()).sum();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = dateFormat.parse(cart.getDate());
			
			order = new Order(foodItems, date, amount, "Paid", user);
			order = orderRepo.save(order);
		}
		
		return order;
	}
	
	public Order updateOrder(Order order){
		return orderRepo.save(order);
	}
	
	public Order deleteOrder(Integer id) {
		Order order = orderRepo.findById(id).orElse(null);
		
		if(order != null) {
			order.setIs_dropped(true);
			order = orderRepo.save(order);
		}
		
		return order;
	}
}















