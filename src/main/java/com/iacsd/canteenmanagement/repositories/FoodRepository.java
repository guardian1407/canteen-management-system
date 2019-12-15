package com.iacsd.canteenmanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iacsd.canteenmanagement.pojos.Food;

@Repository
public interface FoodRepository extends CrudRepository<Food, Integer>{

}
