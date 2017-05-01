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

import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.services.CustomerSer;

@Controller
public class CustomerCon {
	
@Autowired CustomerSer customerS;
	
	@RequestMapping (value = "/showCustomers", method = RequestMethod.GET)
	public String showCustomer(Model m) {

		// Get all info in the customer array
		ArrayList<Customer> customers = customerS.getAll();
		m.addAttribute("customers", customers);

		// Display all customers
		return "dispCustomer";
	}
	
	@RequestMapping(value="/addCustomer", method=RequestMethod.GET)
	public String getCustomer(@ModelAttribute("cust") Customer customer, BindingResult bind, HttpServletRequest req, Model m){

		// Show add customer page
		return "addCustomer";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String postCustomer(@Valid @ModelAttribute("cust") Customer customer, BindingResult bind, HttpServletRequest req, Model m){
		
		// Save
		customerS.save(customer);

		// Get all info from customers array
		ArrayList<Customer> customers = customerS.getAll();
		m.addAttribute("customers", customers);

		// Display all customers
		return "dispCustomer";
	}
}
