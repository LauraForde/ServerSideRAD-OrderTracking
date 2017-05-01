package com.sales.controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Product;
import com.sales.services.ProductSer;

@Controller
public class ProductCon {
	
	// Creating autowired instance of the ProductSer class
	@Autowired ProductSer productS;
	
	// Show all products
	@RequestMapping (value = "/showProducts", method = RequestMethod.GET)
	public String showProduct(Model m) {
		
		// Get all info from the products table and add to the Product array
		ArrayList<Product> products = productS.getAll();
		m.addAttribute("products", products);
		
		// Display all products
		return "dispProduct";
	}
	
	// Adding product, get all info entered
	@RequestMapping(value="/addProduct", method=RequestMethod.GET)
	public String getProduct(@ModelAttribute("prod") Product product, BindingResult bind, HttpServletRequest req, Model m){
		// Display the add product page
		return "addProduct";
	}

	// Adding to array and adding to database
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String postProduct(@Valid @ModelAttribute("prod") Product product, BindingResult bind, HttpServletRequest req, Model m){

		// Save the product
		productS.save(product);

		// Get all info in the product array
		ArrayList<Product> products = productS.getAll();
		m.addAttribute("products", products);

		// Display all products including newly added product
		return "dispProduct";
	}
}
