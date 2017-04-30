package com.sales.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.sales.models.Order;

@Repository
public interface OrderInter extends CrudRepository<Order, Long>{

}
