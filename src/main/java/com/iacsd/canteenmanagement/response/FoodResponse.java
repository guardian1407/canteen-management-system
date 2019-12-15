package com.iacsd.canteenmanagement.response;

import java.util.List;

import com.iacsd.canteenmanagement.pojos.Food;

public class FoodResponse extends Response{

	private Food food;
	private List<Food> foodList;
	
	public FoodResponse(String message) {
		super(message);
	}

	public FoodResponse(String message, Food food) {
		super(message);
		this.food = food;
	}

	public FoodResponse(String message, List<Food> foodList) {
		super(message);
		this.foodList = foodList;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public List<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}
}
