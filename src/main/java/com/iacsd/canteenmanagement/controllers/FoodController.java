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

import com.iacsd.canteenmanagement.pojos.Food;
import com.iacsd.canteenmanagement.response.FoodResponse;
import com.iacsd.canteenmanagement.services.FoodService;

@RestController
@RequestMapping("/canteenmanagement/food")
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<FoodResponse> getFoodById(@PathVariable Integer id) {
		Food food = foodService.getFoodById(id);
		return food != null ? new ResponseEntity<FoodResponse>(new FoodResponse("", food), HttpStatus.OK) 
				: new ResponseEntity<FoodResponse>(new FoodResponse("Food with id : " + id + " not found."), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getallfood", produces = "application/json")
	public ResponseEntity<FoodResponse> getAllFood() {
		List<Food> foodList = foodService.getAllFood();
		return !foodList.isEmpty() ? new ResponseEntity<FoodResponse>(new FoodResponse("", foodList), HttpStatus.OK) 
				: new ResponseEntity<FoodResponse>(new FoodResponse("Food not found.Menu empty."), HttpStatus.OK);
	}
	
	@PostMapping(value = "/savefood", consumes = "application/json", produces = "application/json")
	public ResponseEntity<FoodResponse> saveFood(@RequestBody Food food) {
		Food savedFood = foodService.saveFood(food);
		return new ResponseEntity<FoodResponse>(new FoodResponse("User saved successfully with id : " + savedFood.getId() + ".", savedFood), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/updatefood", consumes = "application/json", produces = "application/json")
	public ResponseEntity<FoodResponse> updateFood(@RequestBody Food food) {
		Integer id = food.getId();
		Food updatedFood = null;
		
		if(id != null && foodService.getFoodById(id) != null) 
			updatedFood = foodService.updateFood(food);
		
		return updatedFood != null ? new ResponseEntity<FoodResponse>(new FoodResponse("Food with id : " + id + " updated successfully.", updatedFood), HttpStatus.CREATED)
				: new ResponseEntity<FoodResponse>(new FoodResponse("Could not update food.Either food id is invalid or food is not present in the system."), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deletefood/{id}", produces = "application/json")
	public ResponseEntity<FoodResponse> deleteFood(@PathVariable Integer id) {
		Food deletedFood = null;
		
		if(foodService.getFoodById(id) != null) 
			deletedFood = foodService.deleteFood(id);
		
		return deletedFood != null ? new ResponseEntity<FoodResponse>(new FoodResponse("Food with id : " + id + " deleted successfully.", deletedFood), HttpStatus.OK) 
				: new ResponseEntity<FoodResponse>(new FoodResponse("Food with id : " + id + " is not present in the system."), HttpStatus.OK);
	}
}










