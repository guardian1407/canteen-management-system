package com.iacsd.canteenmanagement.controllers;

import java.text.ParseException;
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

import com.iacsd.canteenmanagement.pojos.Cart;
import com.iacsd.canteenmanagement.pojos.Order;
import com.iacsd.canteenmanagement.response.OrderResponse;
import com.iacsd.canteenmanagement.services.OrderService;

@RestController
@RequestMapping("/canteenmanagement/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<OrderResponse> getOrderById(@PathVariable Integer id) {
		Order order = orderService.getOrderById(id);
		return order != null ? new ResponseEntity<OrderResponse>(new OrderResponse("", order), HttpStatus.OK) 
							: new ResponseEntity<OrderResponse>(new OrderResponse("Order with id : " + id + " not found."), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getallorder", produces = "application/json")
	public ResponseEntity<OrderResponse> getAllOrders() {
		List<Order> orderList = orderService.getAllOrders();
		return !orderList.isEmpty() ? new ResponseEntity<OrderResponse>(new OrderResponse("", orderList), HttpStatus.OK) 
									: new ResponseEntity<OrderResponse>(new OrderResponse("No orders found."), HttpStatus.OK);
	}
	
	@PostMapping(value = "/saveorder", consumes = "application/json", produces = "application/json")
	public ResponseEntity<OrderResponse> saveOrder(@RequestBody Cart cart) throws ParseException {
		Order savedOrder = orderService.saveOrder(cart);
		return savedOrder != null ? new ResponseEntity<OrderResponse>(new OrderResponse("Order saved successfully with id : " + savedOrder.getId() + ".", savedOrder), HttpStatus.CREATED)
				: new ResponseEntity<OrderResponse>(new OrderResponse("There was some problem while saving order.Please try again"), HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateorder", consumes = "application/json", produces = "application/json")
	public ResponseEntity<OrderResponse> updateOrder(@RequestBody Order order) {
		Integer id = order.getId();
		Order updatedOrder = null;
		
		if(id != null && orderService.getOrderById(id) != null) 
			updatedOrder = orderService.updateOrder(order);
		
		return updatedOrder != null ? new ResponseEntity<OrderResponse>(new OrderResponse("Order with id : " + id + " updated successfully.", updatedOrder), HttpStatus.CREATED)
				: new ResponseEntity<OrderResponse>(new OrderResponse("Could not update order.Either order id is invalid or order is not present in the system."), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteorder/{id}", produces = "application/json")
	public ResponseEntity<OrderResponse> deleteOrder(@PathVariable Integer id) {
		Order deletedOrder = null;
		
		if(orderService.getOrderById(id) != null) 
			deletedOrder = orderService.deleteOrder(id);
		
		return deletedOrder != null ? new ResponseEntity<OrderResponse>(new OrderResponse("Order with id : " + id + " deleted successfully.", deletedOrder), HttpStatus.OK) 
									: new ResponseEntity<OrderResponse>(new OrderResponse("Order with id : " + id + " is not present in the system."), HttpStatus.OK);
	}
}

















