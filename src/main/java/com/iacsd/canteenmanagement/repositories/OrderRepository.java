package com.iacsd.canteenmanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iacsd.canteenmanagement.pojos.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{

}
