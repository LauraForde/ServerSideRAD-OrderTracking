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
	
	@RequestMapping (value = "/showOrders", method = RequestMethod.GET)
	public String showOrder(Model m) {

		ArrayList<Order> orders = orderS.getAll();

		for (Order o1 : orders) {
			System.out.println("name=" + o1.getoId() );
		}

		m.addAttribute("orders", orders);

		return "dispOrder";
	}
	
	@RequestMapping(value="/addOrder", method=RequestMethod.GET)
	public String getOrder(@ModelAttribute("ord") Order order, BindingResult bind, HttpServletRequest req, Model m){
		System.out.println("Request = " + req.getMethod());
		return "addOrder";
	}

	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public String postCustomer(@Valid @ModelAttribute("ord") Order order, BindingResult bind, HttpServletRequest req, Model m){


		System.out.println("HTTP Request = " + req.getMethod());

		orderS.save(order);

		ArrayList<Order> orders = orderS.getAll();

		for (Order o1 : orders) {
			System.out.println("name=" + o1.getoId());
		}

		m.addAttribute("orders", orders);

		return "dispOrder";
	}
}
