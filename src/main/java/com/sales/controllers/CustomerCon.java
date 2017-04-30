package com.sales.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

}
