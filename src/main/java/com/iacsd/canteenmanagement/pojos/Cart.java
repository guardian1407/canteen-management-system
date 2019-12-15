package com.iacsd.canteenmanagement.pojos;

import java.util.List;

public class Cart {

	private List<Item> selectedItems;
	private String date;
	private Integer userId;
	
	public List<Item> getSelectedItems() {
		return selectedItems;
	}
	public void setSelectedItems(List<Item> selectedItems) {
		this.selectedItems = selectedItems;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
