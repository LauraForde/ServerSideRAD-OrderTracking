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

		ArrayList<Customer> customers = customerS.getAll();

		for (Customer c1 : customers) {
			System.out.println("name=" + c1.getcId() );
			
			for (Order o1 : c1.getOrders() ) {
				System.out.println("Oid=" + o1.getoId());
			}
		}

		m.addAttribute("customers", customers);

		return "dispCustomer";
	}
	
	@RequestMapping(value="/addCustomer", method=RequestMethod.GET)
	public String getCustomer(@ModelAttribute("cust") Customer customer, BindingResult bind, HttpServletRequest req, Model m){
		System.out.println("Request = " + req.getMethod());
		return "addCustomer";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String postCustomer(@Valid @ModelAttribute("cust") Customer customer, BindingResult bind, HttpServletRequest req, Model m){


		System.out.println("HTTP Request = " + req.getMethod());

		customerS.save(customer);

		ArrayList<Customer> customers = customerS.getAll();

		for (Customer c1 : customers) {
			System.out.println("name=" + c1.getcId());
		}

		m.addAttribute("customers", customers);

		return "dispCustomer";
	}
}
