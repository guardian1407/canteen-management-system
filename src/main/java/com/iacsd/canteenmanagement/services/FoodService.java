package com.iacsd.canteenmanagement.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.canteenmanagement.pojos.Food;
import com.iacsd.canteenmanagement.repositories.FoodRepository;

@Service
public class FoodService {

	@Autowired
	private FoodRepository foodRepo;
	
	public Food getFoodById(Integer id) {
		Food food = foodRepo.findById(id).orElse(null);
		return food != null && !food.isIs_dropped() ? food : null;
	}

	public List<Food> getAllFood() {
		List<Food> foodList = (List<Food>) foodRepo.findAll();
		
		foodList = foodList.stream()
							.filter(food -> food.isIs_dropped() == false)
							.collect(Collectors.toList());
		
		return foodList;
	}
	
	public Food saveFood(Food food) {
		return foodRepo.save(food);
	}
	
	public Food updateFood(Food food){
		return saveFood(food);
	}
	
	public Food deleteFood(Integer id) {
		Food food = foodRepo.findById(id).orElse(null);
		
		if(food != null) {
			food.setIs_dropped(true);
			food = foodRepo.save(food);
		}
		
		return food;
	}
}







