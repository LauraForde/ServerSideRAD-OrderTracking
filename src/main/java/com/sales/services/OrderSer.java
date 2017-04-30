package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Order;
import com.sales.repositories.OrderInter;

@Service
public class OrderSer {
	@Autowired
	private OrderInter orderInter;
	
	public Order save(Order order){
		return orderInter.save(order);
	}
	
	public ArrayList<Order> getAll(){
		return (ArrayList<Order>) orderInter.findAll();
	}

}
