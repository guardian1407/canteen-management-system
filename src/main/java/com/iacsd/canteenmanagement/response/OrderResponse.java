package com.iacsd.canteenmanagement.response;

import java.util.List;

import com.iacsd.canteenmanagement.pojos.Order;

public class OrderResponse extends Response{

	private Order order;
	private List<Order> orderList;
	
	public OrderResponse(String message) {
		super(message);
	}

	public OrderResponse(String message, Order order) {
		super(message);
		this.order = order;
	}

	public OrderResponse(String message, List<Order> orderList) {
		super(message);
		this.orderList = orderList;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
}
