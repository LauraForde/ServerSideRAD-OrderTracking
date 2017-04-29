package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Product;
import com.sales.repositories.ProductInter;

@Service
public class ProductSer {
	
	@Autowired
	private ProductInter productInter;
	
	public Product save(Product product){
		return productInter.save(product);
	}
	
	public ArrayList<Product> getAll(){
		return (ArrayList<Product>) productInter.findAll();
	}

}
