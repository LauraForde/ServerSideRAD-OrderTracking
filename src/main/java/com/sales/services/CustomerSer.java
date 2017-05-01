package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerInter;

@Service
public class CustomerSer {
	
	@Autowired
	private CustomerInter customerInter;
	
	// Saving info passed in from controller
	public Customer save(Customer customer){
		return customerInter.save(customer);
	}
	
	// Get all info for customer
	public ArrayList<Customer> getAll(){
		return (ArrayList<Customer>) customerInter.findAll();
	}

}
