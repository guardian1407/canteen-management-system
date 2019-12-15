package com.iacsd.canteenmanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iacsd.canteenmanagement.pojos.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
}
