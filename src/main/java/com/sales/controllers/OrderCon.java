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

import com.sales.models.Order;
import com.sales.services.OrderSer;

@Controller
public class OrderCon {

@Autowired OrderSer orderS;
	
	// Show all orders in the database
	@RequestMapping (value = "/showOrders", method = RequestMethod.GET)
	public String showOrder(Model m) {

		// Get all info from orders array
		ArrayList<Order> orders = orderS.getAll();
		m.addAttribute("orders", orders);

		// Display all orders
		return "dispOrder";
	}
	
	// Getting the info entered into the add page
	@RequestMapping(value="/addOrder", method=RequestMethod.GET)
	public String getOrder(@ModelAttribute("ord") Order order, BindingResult bind, HttpServletRequest req, Model m){
		
		// Show add order page
		return "addOrder";
	}

	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public String postCustomer(@Valid @ModelAttribute("ord") Order order, BindingResult bind, HttpServletRequest req, Model m){
		
		// Save
		orderS.save(order);

		// Get all from the array
		ArrayList<Order> orders = orderS.getAll();
		m.addAttribute("orders", orders);

		// Display all orders
		return "dispOrder";
	}
}
